package com.yuwen.citysell.dto;

import lombok.Data;

/**
 * @author 相柳
 * @date 2021/11/22
 */
@Data
public class AddrAddForm {
    /**
     * 收货人姓名
     */
    private String username;

    /**
     * 收货电话
     */
    private String phone;

    /**
     * 收货地址
     */
    private String shippingAddr;

    /**
     * 默认收货地址：0-否，1-是
     */
    private Integer defaultFlag;
}
