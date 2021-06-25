package com.example.controller;

import java.util.Map;

import com.example.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WxUserController
{
    @Autowired
    private WxUserService wxUserService;
 
	/*@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> addUser(String code,String encryptedData,String iv){
        System.out.println(code);
        System.out.println(encryptedData);
        System.out.println(iv);
		Map<String, Object> map = wxUserService.insertUser(code,encryptedData,iv);
		return map;
	}*/

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(String code, String encryptedData, String iv)
    {
        String str = "code = " + code + " ,encryptedData = " + encryptedData + " ,iv=" + iv;
        System.out.println(str);
        return "已收到code等" + str;
    }

    @RequestMapping("/findUserIsExcited")
    @ResponseBody
    public Map<String, Object> findUserIsExcited(String code)
    {
        Map<String, Object> map = wxUserService.findUserIsExcited(code);
        return map;
    }

    @RequestMapping("/excitedOrAdd")
    @ResponseBody
    public Map<String, Object> ExcitedOrAdd(String code, String encryptedData, String iv)
    {
        Map<String, Object> map = wxUserService.excitedOrAdd(code, encryptedData, iv);
        return map;
    }
}		
