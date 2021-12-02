package com.yuwen.citysell.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuwen.citysell.common.IdGenerator;
import com.yuwen.citysell.dao.CartsMapper;
import com.yuwen.citysell.dao.ProductMapper;
import com.yuwen.citysell.dto.CartsPayForm;
import com.yuwen.citysell.entity.Carts;
import com.yuwen.citysell.entity.Product;
import com.yuwen.citysell.service.CartsService;
import com.yuwen.citysell.vo.CartsListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 相柳
 * @date 2021/12/2
 */

@Service
public class CartsServiceImpl extends ServiceImpl<CartsMapper, Carts> implements CartsService {

    @Autowired
    private CartsMapper cartsMapper;

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<CartsListVo> cartsList() {
        return cartsMapper.list();
    }

    @Override
    public void add(String prodId, Integer buyNums) {
        Carts carts = cartsMapper.selectOne(Wrappers.<Carts>query()
                .eq("prod_id", prodId)
                .eq("delete_status", "0"));
        // 购物车没有该商品就新增，否则更新
        Carts record = new Carts();
        if (carts != null) {
            record.setId(carts.getId());
            record.setBuyNums(carts.getBuyNums() + buyNums);
            cartsMapper.updateById(record);
        } else {
            record.setId(idGenerator.nextId());
            record.setBuyNums(buyNums);
            record.setProdId(Long.valueOf(prodId));
            cartsMapper.insert(record);
        }
    }

    @Override
    public void del(String prodId) {
        Carts record = new Carts();
        record.setProdId(Long.valueOf(prodId));
        record.setDeleteStatus(1);
        cartsMapper.update(record, Wrappers.<Carts>update().eq("prod_id", prodId));
    }

    @Override
    public BigDecimal pay(List<CartsPayForm> cartsPayFormList) {
        // 1.计算总金额
        BigDecimal ret = BigDecimal.ZERO;
        for (CartsPayForm form : cartsPayFormList) {
            Product product = productMapper.selectById(form.getProdId());
            BigDecimal sum = BigDecimal.valueOf(form.getBuyNums()).multiply(product.getProdPrice());
            ret = ret.add(sum);
        }
        // 2.结算完毕，删除购物车中的商品
        List<Carts> records = cartsPayFormList.stream().map(item -> {
            Carts carts = new Carts();
            carts.setId(Long.valueOf(item.getId()));
            carts.setDeleteStatus(1);
            return carts;
        }).collect(Collectors.toList());
        this.updateBatchById(records);
        return ret;
    }

    @Override
    public int cartsCount() {
        return cartsMapper.list()
                .stream()
                .map(CartsListVo::getBuyNums)
                .reduce(0, Integer::sum);
    }
}
