package com.yuwen.citysell.common;

/**
 * 封装API的错误码
 *
 * @author macro
 * @date 2019/4/19
 */
public interface IErrorCode {
    /**
     * 获取code
     *
     * @return long
     */
    long getCode();

    /**
     * 获取信息
     *
     * @return String
     */
    String getMessage();
}
