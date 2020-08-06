package com.huazai.springcloud.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pyh
 * @date 2020/7/15 20:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static <T> CommonResult success(T data) {
        return new CommonResult(200, "success", data);
    }

    public static CommonResult failure() {
        return new CommonResult(0, "failure");
    }

    public static CommonResult failure(String message) {
        return new CommonResult(444, message);
    }
}
