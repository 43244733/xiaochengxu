package com.example.controller;

import com.example.bean.Shop;
import com.example.bean.User;
import com.example.service.ShopService;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

/**
 * 商品管理
 */
@Api(tags = "ShopController", description = "商品管理")
@RestController
@MultipartConfig // 文件上传配置
public class ShopController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    /**
     * 文件上传
     * 用 InetAddress.getLocalHost().getHostAddress() 生成服务器IPV4地址
     */
    @ApiOperation("文件上传")
    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public ModelAndView fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request, HttpSession session) throws UnknownHostException {
        Integer id = (Integer) session.getAttribute("shopId");
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "C:\\img\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        String url = filePath + fileName;
        File dest = new File(url);

        // 获取本服务器IPV4地址
        String IPV4 = InetAddress.getLocalHost().getHostAddress().trim();
        shopService.updateFileUpload("http://" + IPV4 + "/image/" + fileName, id);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);
        ModelAndView mv = new ModelAndView("redirect:/selectUserGoods");
        return mv;
    }

    @ApiOperation("商品信息展示")
    @RequestMapping(value = "shopAdministration", method = RequestMethod.GET)
    public ModelAndView shopAdministration(HttpSession session) {
        ModelAndView mv = new ModelAndView("shopAdministration");
        List<Shop> shops = shopService.selectAll();
        session.setAttribute("shops", shops);
        return mv;
    }

    @ApiOperation("删除商品")
    @RequestMapping(value = "deleteGoods", method = RequestMethod.GET)
    public ModelAndView deleteGoods(Integer id) {
        ModelAndView mv = new ModelAndView("redirect:/shopAdministration");
        shopService.deleteGoods(id);
        return mv;
    }

    @ApiOperation("跳转到更新商品信息界面")
    @RequestMapping(value = "updateGoods", method = RequestMethod.GET)
    public ModelAndView updateGoods(Integer id, Model model) {
        ModelAndView mv = new ModelAndView("updateGoods");
        model.addAttribute("updateId", id);
        return mv;
    }

    @ApiOperation("更新商品信息")
    @RequestMapping(value = "doUpdateGoods", method = RequestMethod.GET)
    public ModelAndView doUpdateGoods(Shop shop) {
        ModelAndView mv = new ModelAndView("redirect:/shopAdministration");
        shopService.updateGoods(shop);
        return mv;
    }

    @ApiOperation("跳转到添加商品信息界面")
    @RequestMapping(value = "insertGoods", method = RequestMethod.GET)
    public ModelAndView insertGoods() {
        ModelAndView mv = new ModelAndView("insertGoods");
        return mv;
    }

    @ApiOperation("添加商品信息")
    @RequestMapping(value = "doInsertGoods", method = RequestMethod.GET)
    public ModelAndView doInsertGoods(Shop shop) {
        ModelAndView mv = new ModelAndView("redirect:/shopAdministration");
        shopService.insertGoods(shop);
        return mv;
    }

    /*---------------------------------------------------------------------*/

    @ApiOperation("展示商家自己的商品")
    @RequestMapping(value = "selectUserGoods", method = RequestMethod.GET)
    public ModelAndView selectUserGoods(HttpSession session) {
        ModelAndView mv = new ModelAndView("selectUserGoods");
        User user = (User) session.getAttribute("userLogin");
        List<Shop> shops = shopService.selectAllById(user.getId());
        session.setAttribute("shops", shops);
        return mv;
    }

    @ApiOperation("展示交易数据图")
    @RequestMapping(value = "dataShow", method = RequestMethod.GET)
    public ModelAndView dataShow() {
        ModelAndView mv = new ModelAndView("dataShow");
        return mv;
    }

    @ApiOperation("跳转到添加商家商品信息界面")
    @RequestMapping(value = "insertSellerGoods", method = RequestMethod.GET)
    public ModelAndView insertSellerGoods(Shop shop) {
        ModelAndView mv = new ModelAndView("insertSellerGoods");
        return mv;
    }

    @ApiOperation("添加商家商品信息")
    @RequestMapping(value = "doInsertSellerGoods", method = RequestMethod.GET)
    public ModelAndView doInsertSellerGoods(Shop shop) {
        ModelAndView mv = new ModelAndView("redirect:/selectUserGoods");
        shopService.insertGoods(shop);
        return mv;
    }

    @ApiOperation("跳转到修改商家商品信息界面")
    @RequestMapping(value = "updateSellerGoods", method = RequestMethod.GET)
    public ModelAndView updateSellerGoods(Integer id, Model model) {
        ModelAndView mv = new ModelAndView("updateSellerGoods");
        Shop shop = shopService.selectGoodsById(id);
        model.addAttribute("shop", shop);
        return mv;
    }

    @ApiOperation("修改商家商品信息")
    @RequestMapping(value = "doUpdateSellerGoods", method = RequestMethod.GET)
    public ModelAndView doUpdateSellerGoods(Shop shop) {
        ModelAndView mv = new ModelAndView("redirect:/selectUserGoods");
        shopService.updateGoods(shop);
        return mv;
    }

    @ApiOperation("删除商家商品信息")
    @RequestMapping(value = "deleteSellerGoods", method = RequestMethod.GET)
    public ModelAndView deleteSellerGoods(Integer id) {
        ModelAndView mv = new ModelAndView("redirect:/selectUserGoods");
        shopService.deleteGoods(id);
        return mv;
    }

    @ApiOperation("跳转到文件上传页面")
    @RequestMapping(value = "file", method = RequestMethod.GET)
    public ModelAndView file(Integer id, HttpSession session) {
        ModelAndView mv = new ModelAndView("file");
        session.setAttribute("shopId", id);
        return mv;
    }

    @ApiOperation("返回所有商品信息")
    @RequestMapping(value = "/showGoods", produces = "application/json; charset=utf-8")
    public List<Shop> showGoods() {
        return shopService.selectAll();
    }

    @ApiOperation("返回随机推荐")
    @RequestMapping(value = "indexRecommend", produces = "application/json; charset=utf-8")
    public List<Shop> indexRecommend() {
        return shopService.indexRecommend();
    }

    @ApiOperation("返回最新的六条历史查询记录")
    @RequestMapping(value = "selectHistoryTopSix", produces = "application/json; charset=utf-8")
    public List<Shop> selectHistoryTopSix(String wxId) {
        return shopService.selectHistoryTopSix(wxId);
    }

    @ApiOperation("清空历史记录")
    @RequestMapping(value = "deleteHistory", produces = "application/json; charset=utf-8")
    public void deleteHistory(String wxId) {
        shopService.deleteHistory(wxId);
    }

    @ApiOperation("添加历史记录")
    @RequestMapping(value = "insertHistory", produces = "application/json; charset=utf-8")
    public void insertHistory(Integer gId, String wxId) {
        shopService.insertHistory(gId, wxId);
    }
}
