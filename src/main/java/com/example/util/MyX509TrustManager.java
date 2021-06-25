package com.example.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 类名: MyX509TrustManager.java</br>
 * 描述: 信任管理器</br>
 * 开发人员：wangl</br>
 * 创建时间： 2018-01-09</br>
 */
public class MyX509TrustManager implements X509TrustManager {


    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}