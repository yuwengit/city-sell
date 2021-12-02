package com.yuwen.citysell.enums;

import com.yuwen.citysell.common.IErrorCode;

/**
 * 枚举了一些常用API操作码
 *
 * @author macro
 * @date 2019/4/19
 */
public enum ResultCode implements IErrorCode {
    /**
     * 结果枚举
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败");
    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
