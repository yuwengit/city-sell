package com.yuwen.citysell.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuwen.citysell.entity.Carts;
import com.yuwen.citysell.vo.CartsListVo;

import java.util.List;

/**
 * @author 相柳
 * @date 2021/12/2
 */
public interface CartsMapper extends BaseMapper<Carts> {

    /**
     * 购物车列表
     *
     * @return List<CartsListVo>
     */
    List<CartsListVo> list();
}
