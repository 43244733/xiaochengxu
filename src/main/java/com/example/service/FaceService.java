package com.example.service;


public interface FaceService {

    /**
     * 人脸录入
     *
     * @param filePath String
     */
    void addFace(String filePath);

    /**
     * 人脸登录
     *
     * @param filePath String
     * @return
     */
    boolean loginByFace(String filePath);
}
