package com.example.controller;

import com.example.bean.Article;
import com.example.bean.View;
import com.example.bean.ViewResult;
import com.example.service.ArticleService;
import com.example.util.HttpRequest;
import com.example.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.common.collect.CopyOnWriteHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文章管理
 */
@Api(tags = "ArticleController", description = "文章管理")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private RedisUtil redisUtil;

    // 日志记录
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    /*@ApiOperation("防止别人搞数据库")
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public ModelAndView nihao(HttpSession session) {
        ModelAndView mv = new ModelAndView("nihao");
        return mv;
    }*/

    @ApiOperation("商家后台主页")
    @RequestMapping(value = {"/", "master"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView("index");
        long l = System.currentTimeMillis();
        httpServletRequest.setAttribute("articleList", articleService.selectAllArticle());
        httpServletRequest.setAttribute("articleCount", articleService.selectArticleCount());
        System.out.println("花费了：" + (System.currentTimeMillis() - l));
        return mv;
    }

    @ApiOperation("跳转文章添加页面")
    @RequestMapping(value = "insertArticle", method = RequestMethod.GET)
    public ModelAndView insertArticle() {
        ModelAndView mv = new ModelAndView("insertArticle");
        return mv;
    }

    @ApiOperation("文章添加")
    @RequestMapping(value = "doInsertArticle", method = RequestMethod.GET)
    public ModelAndView doInsertArticle(Article article) {
        articleService.insertArticle(article);
        ModelAndView mv = new ModelAndView("redirect:/selectAllArticle");
        return mv;
    }

    @ApiOperation("查询所有文章 返回json")
    @RequestMapping(value = "/showArticle", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public List<Article> showArticle() {
        return articleService.selectAllArticle();
    }

    @ApiOperation("查询是否已看过 返回json")
    @RequestMapping(value = "/selectAllView", produces = "application/json; charset=utf-8")
    public List<View> selectAllView(String wxId) {
        return articleService.selectAllView(wxId);
    }

    @ApiOperation("根据文章id查询文章 并增加浏览次数和“已读”标签")
    @RequestMapping(value = "/selectArticleById", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public Article selectArticleById(Integer aId, String wxId) {
        String key = "article:id:" + aId + ":num:";

        // 先判断该用户是否阅读过本篇文章
        String look = articleService.selectViewById(aId, wxId);
        // 如果没有读过
        if (look == null || !look.equals("1")) {
            articleService.insertView(aId, wxId);
        }

        Article article = articleService.selectArticleById(aId);

        // 对缓存查询加锁，如果KEY不存在，就加锁，然后查DB入缓存，
        // 然后解锁；其他进程如果发现有锁就等待，然后等解锁后返回数据或者进入DB查询
        if (redisUtil.get(key) == null) {
            Lock lock = new ReentrantLock();
            try {
                lock.lock();
                if (redisUtil.get(key) == null) {
                    Integer articleNum = article.getNum() + 1;
                    redisUtil.set(key, articleNum);
                } else {
                    redisUtil.incr(key, 1);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        } else {
            // 阅读量+1
            redisUtil.incr(key, 1);
        }
        Integer integer = (Integer) redisUtil.get(key);
        article.setNum(integer);

        LOGGER.info("根据文章id查询文章:article:id:" + aId + ":num:" + integer);
        return article;
    }

    // 增加浏览次数和“已读”标签
 /*   @RequestMapping(value = "/updateNum", method = RequestMethod.GET)
    public String updateNum(Integer aId, String wxId) {
        String key = "article:id:" + aId + ":num:";
        // 先判断该用户是否阅读过本篇文章
//        View view = articleService.selectViewById(aId, wxId);
//        if (view == null) {
//            articleService.insertView(aId, wxId);
//        }

        if (redisUtil.get(key) == null) {
            Integer articleNum = articleService.selectArticleNumByAId(aId);
            redisUtil.set(key, articleNum);
        } else {
            // 阅读量+1
            redisUtil.incr(key, 1);
        }
        LOGGER.info("增加浏览次数和“已读”标签:article:id:" + aId + ":num:" + redisUtil.get(key));
        return "增加浏览次数:article:id:" + aId + ":num:" + redisUtil.get(key);
        *//*Article article = articleService.selectArticleById(id);
        articleService.updateNum(id, article.getNum() + 1);*//*
    }*/

    @ApiOperation("查询文章ID、题目以及是否已阅读过")
    @RequestMapping(value = "/selectAll", produces = "application/json; charset=utf-8")
    public ViewResult selectAll(String wxId) {
        List<Article> articles = articleService.selectAllArticleIdAndTitle();
        List<View> views = articleService.selectAllView(wxId);
        ViewResult viewResult = new ViewResult(articles, views);
        return viewResult;
    }

    @ApiOperation("查询所有文章")
    @RequestMapping(value = "selectAllArticle", method = RequestMethod.GET)
    public ModelAndView selectAllArticle(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("doSelectAllArticle");
        request.setAttribute("articleList", articleService.selectAllArticle());
        return mv;
    }

    @ApiOperation("把修改内容返回页面")
    @RequestMapping(value = "updateArticle", method = RequestMethod.GET)
    public ModelAndView updateArticle(Model model, Integer id) {
        ModelAndView mv = new ModelAndView("updateArticle");
        Article article = articleService.selectArticleById(id);
        model.addAttribute("article", article);
        return mv;
    }

    @ApiOperation("修改文章")
    @RequestMapping(value = "doUpdateArticle", method = RequestMethod.GET)
    public ModelAndView doUpdateArticle(Article article) {
        ModelAndView mv = new ModelAndView("redirect:/selectAllArticle");
        articleService.updateArticle(article);
        return mv;
    }

    @ApiOperation("跳转删除文章页面")
    @RequestMapping(value = "deleteArticle", method = RequestMethod.GET)
    public ModelAndView deleteArticle(Model model) {
        ModelAndView mv = new ModelAndView("deleteArticle");
        return mv;
    }

    @ApiOperation("删除文章")
    @RequestMapping(value = "doDeleteArticle", method = RequestMethod.GET)
    public ModelAndView doDeleteArticle(Integer id) {
        ModelAndView mv = new ModelAndView("redirect:/selectAllArticle");
        articleService.deleteArticle(id);
        return mv;
    }

}
