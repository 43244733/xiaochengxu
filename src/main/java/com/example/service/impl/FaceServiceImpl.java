package com.example.service.impl;

import com.example.dao.FaceDao;
import com.example.service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaceServiceImpl implements FaceService {

    @Autowired
    private FaceDao faceDao;

    /**
     * 人脸录入
     *
     * @param filePath String
     */
    @Override
    public void addFace(String filePath) {
        // 先获取对应的faceSet
        FaceDao.FaceSetResponseEntity faceSetResponseEntity = null;
        try {
            faceSetResponseEntity = faceDao.getFaceSetDetail();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // 判断faceSet是否存在
        if (faceSetResponseEntity == null) {
            // 创建新的faceSet
            faceDao.faceSetCreate();
        }

        // 检视人脸
        FaceDao.DetectResponseEntity detectResponseEntity = faceDao.detect(filePath);

        for (FaceDao.FaceEntity face : detectResponseEntity.getFaces()) {
            faceDao.addFaceToFaceSet(face.getFace_token());
        }
    }

    /**
     * 人脸登录
     *
     * @param filePath String
     * @return
     */
    @Override
    public boolean loginByFace(String filePath) {
        // 获取faceSet
        FaceDao.FaceSetResponseEntity faceSetResponseEntity = null;
        try {
            faceSetResponseEntity = faceDao.getFaceSetDetail();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (faceSetResponseEntity == null) {
            faceDao.faceSetCreate();
            faceSetResponseEntity = faceDao.getFaceSetDetail();
        }

        FaceDao.DetectResponseEntity detectResponseEntity = faceDao.detect(filePath);
        String ft1 = null;

        if (detectResponseEntity.getFace_num() >= 1) {
            ft1 = detectResponseEntity.getFaces().get(0).getFace_token();
        } else {
            return false;
        }

        for (String ft2 : faceSetResponseEntity.getFace_tokens()) {
            if (faceDao.compareFace(ft1, ft2)) {
                return true;
            }
        }

//        new File(filePath).delete();      // 删除登录人脸图片
        return false;
    }
}
