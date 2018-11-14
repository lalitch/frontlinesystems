package com.plessentials.frontlinesystems.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceUtils {
    public static String getLocalizedString(String key, String... params) {
        ResourceBundle resources = ResourceBundle.getBundle("Resources", Locale.forLanguageTag("en_US"));
        return MessageFormat.format(resources.getString(key), params);
    }
}
