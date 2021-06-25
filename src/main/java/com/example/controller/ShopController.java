package com.example.controller;

import com.example.bean.Shop;
import com.example.bean.User;
import com.example.service.ShopService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@SpringBootApplication
@MultipartConfig // 文件上传配置
public class ShopController
{
    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    // 商品信息展示
    @RequestMapping(value = "shopAdministration", method = RequestMethod.GET)
    public ModelAndView insertArticle(HttpSession session)
    {
        ModelAndView mv = new ModelAndView("shopAdministration");
        List<Shop> shops = shopService.selectAll();
        session.setAttribute("shops", shops);
        return mv;
    }

    // 删除
    @RequestMapping(value = "deleteGoods", method = RequestMethod.GET)
    public ModelAndView insertArticle(Integer id)
    {
        ModelAndView mv = new ModelAndView("redirect:/shopAdministration");
        shopService.deleteGoods(id);
        return mv;
    }

    // 修改
    @RequestMapping(value = "updateGoods", method = RequestMethod.GET)
    public ModelAndView updateGoods(Integer id, Model model)
    {
        ModelAndView mv = new ModelAndView("updateGoods");
        model.addAttribute("updateId", id);
        return mv;
    }

    @RequestMapping(value = "doUpdateGoods", method = RequestMethod.GET)
    public ModelAndView doUpdateGoods(Shop shop)
    {
        ModelAndView mv = new ModelAndView("redirect:/shopAdministration");
        shopService.updateGoods(shop);
        return mv;
    }

    // 添加
    @RequestMapping(value = "insertGoods", method = RequestMethod.GET)
    public ModelAndView insertGoods()
    {
        ModelAndView mv = new ModelAndView("insertGoods");
        return mv;
    }

    @RequestMapping(value = "doInsertGoods", method = RequestMethod.GET)
    public ModelAndView doInsertGoods(Shop shop)
    {
        ModelAndView mv = new ModelAndView("redirect:/shopAdministration");
        shopService.insertGoods(shop);
        return mv;
    }

    // 登录
    @RequestMapping(value = "sellerLogin", method = RequestMethod.GET)
    public ModelAndView sellerLogin()
    {
        ModelAndView mv = new ModelAndView("sellerLogin");
        return mv;
    }

    @RequestMapping(value = "doSellerLogin", method = RequestMethod.GET)
    public ModelAndView doSellerLogin(HttpSession session, String name, String password)
    {
        User user = new User(name, password);
        ModelAndView mv;
        User userResult = userService.searchUser(user);
        if (userResult != null)
        {
            session.setAttribute("userLogin", userResult);
            mv = new ModelAndView("sellerIndex");
        }
        else
        {
            mv = new ModelAndView("error");
        }
        return mv;
    }

    /*---------------------------------------------------------------------*/

    // 展示商家自己的商品
    @RequestMapping(value = "selectUserGoods", method = RequestMethod.GET)
    public ModelAndView selectUserGoods(HttpSession session)
    {
        ModelAndView mv = new ModelAndView("selectUserGoods");
        User user = (User) session.getAttribute("userLogin");
        List<Shop> shops = shopService.selectAllById(user.getId());
        session.setAttribute("shops", shops);
        return mv;
    }

    // 展示交易数据图
    @RequestMapping(value = "dataShow", method = RequestMethod.GET)
    public ModelAndView dataShow()
    {
        ModelAndView mv = new ModelAndView("dataShow");
        return mv;
    }

    // 添加
    @RequestMapping(value = "insertSellerGoods", method = RequestMethod.GET)
    public ModelAndView insertSellerGoods(Shop shop)
    {
        ModelAndView mv = new ModelAndView("insertSellerGoods");
        return mv;
    }

    @RequestMapping(value = "doInsertSellerGoods", method = RequestMethod.GET)
    public ModelAndView doInsertSellerGoods(Shop shop)
    {
        ModelAndView mv = new ModelAndView("redirect:/selectUserGoods");
        shopService.insertGoods(shop);
        return mv;
    }

    // 修改
    @RequestMapping(value = "updateSellerGoods", method = RequestMethod.GET)
    public ModelAndView updateSellerGoods(Integer id, Model model)
    {
        ModelAndView mv = new ModelAndView("updateSellerGoods");
        Shop shop = shopService.selectGoodsById(id);
        model.addAttribute("shop", shop);
        return mv;
    }

    @RequestMapping(value = "doUpdateSellerGoods", method = RequestMethod.GET)
    public ModelAndView doUpdateSellerGoods(Shop shop)
    {
        ModelAndView mv = new ModelAndView("redirect:/selectUserGoods");
        shopService.updateGoods(shop);
        return mv;
    }

    // 删除
    @RequestMapping(value = "deleteSellerGoods", method = RequestMethod.GET)
    public ModelAndView deleteSellerGoods(Integer id)
    {
        ModelAndView mv = new ModelAndView("redirect:/selectUserGoods");
        shopService.deleteGoods(id);
        return mv;
    }

    // 文件上传
    @RequestMapping(value = "file", method = RequestMethod.GET)
    public ModelAndView file(Integer id, HttpSession session)
    {
        ModelAndView mv = new ModelAndView("file");
        session.setAttribute("shopId", id);
        return mv;
    }

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public ModelAndView fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request, HttpSession session)
    {
        Integer id = (Integer) session.getAttribute("shopId");
        if (file.isEmpty())
        {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "C:\\img\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        String url = filePath + fileName;
        File dest = new File(url);
        shopService.updateFileUpload("http://112.74.58.46/image/" + fileName, id);

        if (!dest.getParentFile().exists())
        {
            dest.getParentFile().mkdirs();
        }
        try
        {
            file.transferTo(dest);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);
        ModelAndView mv = new ModelAndView("redirect:/selectUserGoods");
        return mv;
    }

    // 查询返回json
    @RequestMapping(value = "/showGoods", produces = "application/json; charset=utf-8")
    public List<Shop> showArticle()
    {
        return shopService.selectAll();
    }

    // 返回随机推荐json
    @RequestMapping(value = "indexRecommend", produces = "application/json; charset=utf-8")
    public List<Shop> indexRecommend()
    {
        return shopService.indexRecommend();
    }

    // 返回最新的六条历史查询记录
    @RequestMapping(value = "selectHistoryTopSix", produces = "application/json; charset=utf-8")
    public List<Shop> selectHistoryTopSix(String wxId)
    {
        return shopService.selectHistoryTopSix(wxId);
    }

    // 清空历史记录
    @RequestMapping(value = "deleteHistory", produces = "application/json; charset=utf-8")
    public void deleteHistory(String wxId)
    {
        shopService.deleteHistory(wxId);
    }

    // 添加历史记录
    @RequestMapping(value = "insertHistory", produces = "application/json; charset=utf-8")
    public void insertHistory(Integer gId, String wxId)
    {
        shopService.insertHistory(gId, wxId);
    }
}
