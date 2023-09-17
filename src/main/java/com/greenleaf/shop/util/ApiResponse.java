package com.greenleaf.shop.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean successful;
    private String message;
    private T data;
}
