package com.greenleaf.shop.util;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UrlAppend {
    public static String appendQueryParams(String baseUrl, Map<String, String[]> params) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        if (params != null && !params.isEmpty()) {
            urlBuilder.append("?");
            Set<Map.Entry<String, String[]>> entrySet = params.entrySet();
            int entryCount = 0;
            for (Map.Entry<String, String[]> entry : entrySet) {
                String key = entry.getKey();
                String[] values = entry.getValue();
                for (String value : values) {
                    if (entryCount > 0) {
                        urlBuilder.append("&");
                    }
                    urlBuilder.append(key).append("=").append(value);
                    entryCount++;
                }
            }
        }
        return urlBuilder.toString();
    }
}
