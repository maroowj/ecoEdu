package com.muzisoft.education.utils;

import java.text.DecimalFormat;

public class TextUtils {
    public static String toZeroZeroFormat(Integer value) {
        return new DecimalFormat("00").format(value);
    }
}
