package com.example.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Paths;
import java.util.List;


@ConfigurationProperties("face.config")
@Repository
@Data
public class FaceDao {
    @Autowired
    private RestTemplate restTemplate;

    private String apiKey;
    private String apiSecret;
    private String outerId;

    /**
     * 人脸识别
     */
    public DetectResponseEntity detect(String filePath) {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        // 普通域
        builder.part("api_key", apiKey);
        builder.part("api_secret", apiSecret);

        // 文件域
        builder.part("image_file", new FileSystemResource(Paths.get(filePath)), MediaType.IMAGE_PNG);

        // build完整的消息体
        MultiValueMap<String, HttpEntity<?>> request = builder.build();

        ResponseEntity<DetectResponseEntity> entity = restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/detect"
                , request, DetectResponseEntity.class);

        return entity.getBody();
    }

    /**
     * 创建faceset
     */
    public void faceSetCreate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("api_key", apiKey);
        map.add("api_secret", apiSecret);
        map.add("outer_id", outerId);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/faceset/create", request, String.class);
    }

    public FaceSetResponseEntity getFaceSetDetail() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("api_key", apiKey);
        map.add("api_secret", apiSecret);
        map.add("outer_id", outerId);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<FaceSetResponseEntity> entity = restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/faceset/getdetail", request, FaceSetResponseEntity.class);
        return entity.getBody();
    }

    public void addFaceToFaceSet(String faceTokens) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("api_key", apiKey);
        map.add("api_secret", apiSecret);
        map.add("outer_id", outerId);
        map.add("face_tokens", faceTokens);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/faceset/addface", request, String.class);
    }

    public boolean compareFace(String faceToken1, String faceToken2) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("api_key", apiKey);
        multipartBodyBuilder.part("api_secret", apiSecret);
        multipartBodyBuilder.part("face_token1", faceToken1);
        multipartBodyBuilder.part("face_token2", faceToken2);

        MultiValueMap<String, HttpEntity<?>> build = multipartBodyBuilder.build();


        ResponseEntity<CompareResponseEntity> entity = restTemplate.postForEntity("https://api-cn.faceplusplus.com/facepp/v3/compare", build, CompareResponseEntity.class);
        System.out.println(entity);

        CompareResponseEntity body = entity.getBody();
        if (body.getConfidence() >= body.getThresholds().e5) {
            return true;
        } else {
            return false;
        }
    }

    @Data
    public static class CompareResponseEntity {
        private Double confidence;
        private ThresholdsResponseEntity thresholds;
    }

    @Data
    public static class ThresholdsResponseEntity {
        @JsonProperty("1e-5")
        private Double e5;
    }

    @Data
    public static class FaceSetResponseEntity {
        private String outer_id;
        private Integer face_count;
        private List<String> face_tokens;
    }

    @Data
    public static class DetectResponseEntity {
        private String request_id;
        private Integer face_num;
        private List<FaceEntity> faces;
    }

    @Data
    public static class FaceEntity {
        private String face_token;
    }
}
