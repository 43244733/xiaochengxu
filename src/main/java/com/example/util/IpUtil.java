package com.example.util;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 获取本机所有IP地址
 */
public class IpUtil {
    public static List<String> getLocalIPList() {
        List<String> ipList = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface;
            Enumeration<InetAddress> inetAddresses;
            InetAddress inetAddress;
            String ip;
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement();
                inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) { // IPV4
                        ip = inetAddress.getHostAddress();
                        ipList.add(ip);
                    }
                }
            }
        }
        catch (SocketException e) {
            e.printStackTrace();
        }
        return ipList;
    }

    public static void main(String[] args) throws UnknownHostException {
        List<String> ip = IpUtil.getLocalIPList();
        System.out.println("本机Ip为：" + ip);
        System.out.println("本机IPV4为：" + InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostAddress().length());
    }
}
