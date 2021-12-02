package com.yuwen.citysell.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
@TableName("t_carts")
public class Carts {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商品id
     */
    private Long prodId;

    /**
     * 购买数量
     */
    private Integer buyNums;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long modifierId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标识：0-否，1-是
     */
    private Integer deleteStatus;
}