package com.yuwen.citysell.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("t_product")
public class Product {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商品名称
     */
    private String prodName;

    /**
     * 商品信息
     */
    private String prodInfo;

    /**
     * 商品规格
     */
    private String prodUnit;

    /**
     * 商品价格
     */
    private BigDecimal prodPrice;

    /**
     * 总库存
     */
    private Integer totalStock;

    /**
     * 剩余库存
     */
    private Integer remainStock;

    /**
     * 商品图片路径
     */
    private String imgPath;

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