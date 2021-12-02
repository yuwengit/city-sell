package com.yuwen.citysell.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 相柳
 * @date 2021/11/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddrListVo {

    /**
     * 主键
     */
    private String id;

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
