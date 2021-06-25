package com.example.service;

import java.util.Map;

public interface WxUserService
{

    /* 1.添加一个新的用户 */
    public Map<String, Object> insertUser(String code, String encryptedData, String iv);

    /* 2.检查用户是否已经授权 */
    public Map<String, Object> findUserIsExcited(String code);

    /* 3.检查用户是否存在，存在则返回用户信息，不存在则保存到数据库，并返回数据信息 */
    public Map<String, Object> excitedOrAdd(String code, String encryptedData, String iv);

}
