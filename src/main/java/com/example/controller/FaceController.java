package com.example.controller;

import com.example.service.FaceService;
import com.example.util.ImageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * 人脸识别
 */
@Api(tags = "FaceController", description = "人脸识别")
@Controller
@RequestMapping("/face")
public class FaceController {

    @Autowired
    private FaceService faceService;

    // 日志记录
    private static final Logger LOGGER = LoggerFactory.getLogger(FaceController.class);

    @ApiOperation("人脸识别登录跳转")
    @RequestMapping("/faceLogin")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("faceLogin");
        return modelAndView;
    }

    @ApiOperation("人脸识别录入")
    @RequestMapping("/doUpload")
    @ResponseBody
    public ModelAndView doUpload(@RequestParam("imgData") String imgData, HttpServletRequest request) {
        String savePath = request.getServletContext().getRealPath("img/face/upload/");
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");

        ImageUtils.generateImage(imgData.substring(22), savePath, fileName);

        faceService.addFace(savePath + fileName);

        ModelAndView modelAndView = new ModelAndView("sellerIndex");
        return modelAndView;
    }

    @ResponseBody
    @ApiOperation("人脸识别登录")
    @RequestMapping("/doLogin")
    public ModelAndView doLogin(@RequestParam("imgData") String imgData, HttpServletRequest request) {
        String savePath = request.getServletContext().getRealPath("img/face/login/");
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".png";

        System.out.println(savePath);
        ImageUtils.generateImage(imgData.substring(22), savePath, fileName);

        boolean loginIn = faceService.loginByFace(savePath + fileName);

        if (loginIn) {
            LOGGER.info("人脸识别登录成功");
            return new ModelAndView("sellerIndex");
        } else {
            LOGGER.info("人脸识别登录失败");
            return new ModelAndView("sellerLogin");
        }
    }

}
