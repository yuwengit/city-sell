package com.yuwen.citysell.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuwen.citysell.dao.ProductMapper;
import com.yuwen.citysell.entity.Product;
import com.yuwen.citysell.service.ProductService;
import com.yuwen.citysell.vo.PageVo;
import com.yuwen.citysell.vo.ProdInfoVo;
import com.yuwen.citysell.vo.ProdListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 相柳
 * @date 2021/11/29
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageVo<ProdListVo> list(int pageNum, int pageSize) {
        Page<Product> param = new Page<>(pageNum, pageSize, true);
        Page<Product> page = productMapper.selectPage(param, Wrappers.<Product>query().eq("delete_status", "0"));
        List<ProdListVo> collect = page.getRecords()
                .stream()
                .map(item -> {
                    ProdListVo vo = new ProdListVo();
                    vo.setId(item.getId());
                    vo.setProdInfo(item.getProdInfo());
                    vo.setRemainStock(item.getRemainStock());
                    vo.setProdPrice(item.getProdPrice());
                    vo.setImgPath(item.getImgPath());
                    return vo;
                }).collect(Collectors.toList());

        PageVo<ProdListVo> pageVo = new PageVo<>();
        pageVo.setCurrent(pageNum);
        pageVo.setRecords(collect);
        pageVo.setTotal(page.getTotal());
        pageVo.setSize(page.getSize());
        return pageVo;
    }

    @Override
    public ProdInfoVo getProdInfo(String id) {
        Product product = productMapper.selectById(id);

        ProdInfoVo ret = new ProdInfoVo();
        ret.setId(String.valueOf(product.getId()));
        ret.setProdInfo(product.getProdInfo());
        ret.setImgPath(product.getImgPath());
        ret.setProdPrice(product.getProdPrice());
        ret.setProdName(product.getProdName());
        ret.setProdUnit(product.getProdUnit());
        return ret;
    }
}
