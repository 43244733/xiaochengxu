package com.example.controller;

import com.example.bean.Article;
import com.example.bean.View;
import com.example.bean.ViewResult;
import com.example.service.ArticleService;
import com.example.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@SpringBootApplication
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private RedisUtil redisUtil;

    // 日志记录
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    // 防止别人乱搞数据库
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public ModelAndView nihao(HttpSession session) {
        ModelAndView mv = new ModelAndView("nihao");
        return mv;
    }

    // 主页
    @RequestMapping(value = "master", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView mv = new ModelAndView("index");
        session.setAttribute("articleList", articleService.selectAllArticle());
        session.setAttribute("articleCount", articleService.selectArticleCount());
        return mv;
    }

    // 增加
    @RequestMapping(value = "insertArticle", method = RequestMethod.GET)
    public ModelAndView insertArticle() {
        ModelAndView mv = new ModelAndView("insertArticle");
        return mv;
    }

    @RequestMapping(value = "doInsertArticle", method = RequestMethod.GET)
    public ModelAndView doInsertArticle(Article article) {
        articleService.insertArticle(article);
        ModelAndView mv = new ModelAndView("redirect:/selectAllArticle");
        return mv;
    }

    // 查询返回json
    @RequestMapping(value = "/showArticle", produces = "application/json; charset=utf-8")
    public List<Article> showArticle() {
        return articleService.selectAllArticle();
    }

    // 查询返回json
    @RequestMapping(value = "/selectAllView", produces = "application/json; charset=utf-8")
    public List<View> selectAllView(String wxId) {
        return articleService.selectAllView(wxId);
    }

    // 根据文章id查询文章 并增加浏览次数和“已读”标签
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

        if (redisUtil.get(key) == null) {
            Integer articleNum = article.getNum() + 1;
            redisUtil.set(key, articleNum);
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

    // 查询返回json
    // 查询文章ID、题目以及是否已阅读过
    @RequestMapping(value = "/selectAll", produces = "application/json; charset=utf-8")
    public ViewResult selectAll(String wxId) {
        List<Article> articles = articleService.selectAllArticleIdAndTitle();
        List<View> views = articleService.selectAllView(wxId);
        ViewResult viewResult = new ViewResult(articles, views);
        return viewResult;
    }

    // 查询
    @RequestMapping(value = "selectAllArticle", method = RequestMethod.GET)
    public ModelAndView selectAllArticle(HttpSession session) {
        ModelAndView mv = new ModelAndView("doSelectAllArticle");
        session.setAttribute("articleList", articleService.selectAllArticle());
        return mv;
    }

    // 把修改内容返回页面
    @RequestMapping(value = "updateArticle", method = RequestMethod.GET)
    public ModelAndView updateArticle(Model model, Integer id) {
        ModelAndView mv = new ModelAndView("updateArticle");
        Article article = articleService.selectArticleById(id);
        model.addAttribute("article", article);
        return mv;
    }

    // 修改
    @RequestMapping(value = "doUpdateArticle", method = RequestMethod.GET)
    public ModelAndView doUpdateArticle(Article article) {
        ModelAndView mv = new ModelAndView("redirect:/selectAllArticle");
        articleService.updateArticle(article);
        return mv;
    }

    // 删除
    @RequestMapping(value = "deleteArticle", method = RequestMethod.GET)
    public ModelAndView deleteArticle(Model model) {
        ModelAndView mv = new ModelAndView("deleteArticle");
        return mv;
    }

    @RequestMapping(value = "doDeleteArticle", method = RequestMethod.GET)
    public ModelAndView doDeleteArticle(Integer id) {
        ModelAndView mv = new ModelAndView("redirect:/selectAllArticle");
        articleService.deleteArticle(id);
        return mv;
    }


}