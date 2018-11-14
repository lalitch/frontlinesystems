package com.plessentials.frontlinesystems.utils;

public class StringUtils {
    public static boolean IsNullEmptyOrBlank(String string) {
        return string == null || string.isEmpty() || string.isBlank();
    }
}
