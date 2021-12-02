package com.yuwen.citysell.service;

import com.yuwen.citysell.dto.CartsPayForm;
import com.yuwen.citysell.vo.CartsListVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 相柳
 * @date 2021/12/2
 */
public interface CartsService {
    /**
     * 购物车列表
     *
     * @return List<CartsListVo>
     */
    List<CartsListVo> cartsList();

    /**
     * 添加购物车
     *
     * @param prodId prodId
     */
    void add(String prodId, Integer buyNums);

    /**
     * 删除购物车中商品
     *
     * @param prodId prodId
     */
    void del(String prodId);

    /**
     * 结算购物车
     *
     * @param cartsPayFormList cartsPayFormList
     * @return BigDecimal
     */
    BigDecimal pay(List<CartsPayForm> cartsPayFormList);

    /**
     * 统计购物车商品数量
     *
     * @return int
     */
    int cartsCount();
}
