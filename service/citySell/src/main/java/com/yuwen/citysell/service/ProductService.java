package com.yuwen.citysell.service;

import com.yuwen.citysell.vo.CommonResult;
import com.yuwen.citysell.vo.PageVo;
import com.yuwen.citysell.vo.ProdInfoVo;
import com.yuwen.citysell.vo.ProdListVo;

import java.util.List;

/**
 * @author 相柳
 * @date 2021/11/29
 */
public interface ProductService {

    /**
     * 列表查询
     *
     * @return
     */
    PageVo<ProdListVo> list(int pageNum, int pageSize);

    /**
     * 获取商品信息
     *
     * @param id id
     * @return ProdInfoVo
     */
    ProdInfoVo getProdInfo(String id);
}
