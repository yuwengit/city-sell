package com.yuwen.citysell.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 相柳
 * @date 2021/12/1
 */

@Data
public class ProdInfoVo {
    /**
     * id
     */
    private String id;

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
     * 商品图片路径
     */
    private String imgPath;
}
