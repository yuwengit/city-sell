package com.yuwen.citysell.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 相柳
 * @date 2021/11/29
 */

@Data
public class ProdListVo {

    private Long id;

    private BigDecimal prodPrice;

    private String prodInfo;

    private int remainStock;

    private String imgPath;

}
