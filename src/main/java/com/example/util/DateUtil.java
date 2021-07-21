package com.example.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getNowTime() {
        return new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Date());
    }

}
