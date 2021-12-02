package com.yuwen.citysell.controller;

import com.yuwen.citysell.dto.CartsPayForm;
import com.yuwen.citysell.service.CartsService;
import com.yuwen.citysell.vo.CartsListVo;
import com.yuwen.citysell.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车
 *
 * @author 相柳
 * @date 2021/12/2
 */

@RestController
public class CartsController {

    @Autowired
    private CartsService cartsService;

    /**
     * 购物车列表
     *
     * @return CommonResult<List < CartsListVo>>
     */
    @GetMapping("/carts/list")
    public CommonResult<List<CartsListVo>> list() {
        return CommonResult.success(cartsService.cartsList());
    }

    /**
     * 添加购物车
     *
     * @param prodId prodId
     * @return CommonResult<Void>
     */
    @PostMapping("/carts/add")
    public CommonResult<Void> add(String prodId, Integer buyNums) {
        cartsService.add(prodId, buyNums);
        return CommonResult.success();
    }

    /**
     * 删除购物车中的商品
     *
     * @param prodId prodId
     * @return CommonResult<Void>
     */
    @PostMapping("/carts/del")
    public CommonResult<Void> del(String prodId) {
        cartsService.del(prodId);
        return CommonResult.success();
    }

    /**
     * 结算购物车
     */
    @PostMapping("/carts/pay")
    public CommonResult<BigDecimal> pay(@RequestBody List<CartsPayForm> cartsPayFormList) {
        return CommonResult.success(cartsService.pay(cartsPayFormList));
    }

    /**
     * 统计购物车商品数量
     *
     * @return CommonResult<Integer>
     */
    @GetMapping("/carts/count")
    public CommonResult<Integer> count() {
        return CommonResult.success(cartsService.cartsCount());
    }
}
