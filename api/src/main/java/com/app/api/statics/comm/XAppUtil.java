package com.app.api.statics.comm;


import org.springframework.util.StringUtils;

public class XAppUtil {

    /**
     * Value is not empty
     *
     * @param str
     * @return
     */
    public static Boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }


    /**
     * Value is not initial
     *
     * @param val
     * @return
     */
    public static Boolean isNotInitialVal(long val) {
        return val != 0L;
    }

}
