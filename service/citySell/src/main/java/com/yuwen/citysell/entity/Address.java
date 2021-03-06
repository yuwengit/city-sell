package com.yuwen.citysell.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 收货地址
 *
 * @author 相柳
 * @date 2021/11/17
 */

@Data
@TableName("t_address")
public class Address {

    /**
     * 主键
     */
    private Long id;

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

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 更新人id
     */
    private Long modifierId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除状态：0-否，1-是
     */
    private Integer deleteStatus;


}
