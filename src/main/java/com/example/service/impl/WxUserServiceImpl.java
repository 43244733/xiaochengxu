package com.example.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.mapper.WxuserMapper;
import com.example.model.Wxuser;
import com.example.model.WxuserExample;
import com.example.service.WxUserService;
import com.example.util.HttpRequest;
import com.example.util.WeChatUserInfo;
import com.example.util.WxConstUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sf.json.JSONObject;

@Service
public class WxUserServiceImpl implements WxUserService
{

    @Autowired
    private WxuserMapper wxUserMapper;

    @Override
    public Map<String, Object> insertUser(String code, String encryptedData, String iv)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        if (code == null || code.length() == 0)
        {
            map.put("statue", 500);
            map.put("msg", "登录凭证为空");
            return map;
        }
        JSONObject object = GetOpenId(code);
        Wxuser wxuser = new Wxuser();
        map.put("statue", 200);
        map.put("msg", "查询到用户的全部信息");
        // 2、对encryptedData加密数据进行AES解密
        // String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
        addWxUser(encryptedData, iv, map, object, wxuser);
        map.put("data", wxuser);
        return map;
    }

    private int addWxUser(String encryptedData, String iv, Map<String, Object> map, JSONObject object, Wxuser wxuser)
    {
        int insert = 0;
        if (StringUtils.isNotBlank(object.getString("openid")) && StringUtils.isNotBlank(object.getString("sessionkey")))
        {
            JSONObject userInfo = WeChatUserInfo.getUserInfo(encryptedData, object.getString("sessionkey"), iv);
            if (userInfo != null)
            {
                wxuser.setCity(userInfo.getString("city"));
                wxuser.setCountry(userInfo.getString("country"));
                wxuser.setGender(userInfo.getInt("gender"));
                wxuser.setIconstr(userInfo.getString("avatarUrl"));
                wxuser.setNickname(userInfo.getString("nickName"));
                wxuser.setProvince(userInfo.getString("province"));
                wxuser.setRegistertime(new Date());
                wxuser.setWxopenid(object.getString("openid"));
                if (userInfo.get("unionId") != null)
                {
                    map.put("unionId", userInfo.get("unionId"));
                }
                insert = wxUserMapper.insert(wxuser);
            }
        }
        return insert;
    }

    private JSONObject GetOpenId(String code)
    {
        // 1. 向微信服务器 使用登录凭证 code获取 session_key 和 openid
        // 设置请求的参数
        String params = "appid=" + WxConstUtil.Wx_Const_APPID + "&secret=" + WxConstUtil.Wx_Const_SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        // 发送请求
        String sr = HttpRequest.sendGet(WxConstUtil.Wx_Get_Openid_Url, params);
        // 解析相应的内容（转成 json 的形式）
        JSONObject jsonObject = new JSONObject();
        JSONObject object = jsonObject.fromObject(sr);
        // 获取会话密钥（session_key）
        String session_key = object.get("session_key").toString();
        // 用户的唯一标识（openid）
        String openid = (String) object.get("openid");
        Map<String, String> map = new HashMap<String, String>();
        map.put("openid", openid);
        map.put("sessionkey", session_key);
        JSONObject fromObject = jsonObject.fromObject(map);
        return fromObject;
    }

    @Override
    public Map<String, Object> findUserIsExcited(String code)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        if (code == null || code.length() == 0)
        {
            map.put("statue", 500);
            map.put("msg", "登录凭证为空");
            map.put("IsUse", true);
            return map;
        }
        JSONObject object = GetOpenId(code);
        String openid = (String) object.get("openid");
        List<Wxuser> selectByExample = selectIsExcited(openid);
        if (selectByExample == null || selectByExample.isEmpty())
        {
            map.put("data", selectByExample);
            map.put("statue", 500);
            map.put("msg", "查询内容为空");
            map.put("IsUse", true);
        }
        else
        {
            map.put("data", selectByExample);
            map.put("statue", 200);
            map.put("msg", "查询内容不为空");
            map.put("IsUse", false);
        }
        return map;
    }

    private List<Wxuser> selectIsExcited(String openid)
    {
        WxuserExample example = new WxuserExample();
        WxuserExample.Criteria criteria = example.createCriteria();
        criteria.andWxopenidEqualTo(openid);
        List<Wxuser> selectByExample = wxUserMapper.selectByExample(example);
        return selectByExample;
    }

    @Override
    public Map<String, Object> excitedOrAdd(String code, String encryptedData, String iv)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Wxuser wxuser = new Wxuser();
        // 根据传来的code查询用户的openid
        JSONObject jsonObject = GetOpenId(code);
        String openid = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("sessionkey");
        // 根据openid进行查询，有则传到客户端，无则新建
        List<Wxuser> selectByExample = selectIsExcited(openid);
        if (selectByExample == null || selectByExample.isEmpty())
        {
            int i = addWxUser(encryptedData, iv, map, jsonObject, wxuser);
            if (i > 0)
            {
                System.out.println("增加成功");
                List<Wxuser> isExcited = selectIsExcited(openid);
                map.put("data", isExcited.get(0));
                map.put("statue", 200);
                map.put("msg", "增加成功");
                map.put("IsUse", false);
            }
            else
            {
                map.put("data", null);
                map.put("statue", 500);
                map.put("msg", "增加失败");
                map.put("IsUse", false);
            }
        }
        else
        {
            map.put("data", selectByExample.get(0));
            map.put("statue", 200);
            map.put("msg", "查询内容不为空");
            map.put("IsUse", false);
        }
        return map;
    }

}
