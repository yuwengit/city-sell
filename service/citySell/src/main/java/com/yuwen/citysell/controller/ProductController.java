package com.yuwen.citysell.controller;

import com.yuwen.citysell.service.ProductService;
import com.yuwen.citysell.vo.CommonResult;
import com.yuwen.citysell.vo.PageVo;
import com.yuwen.citysell.vo.ProdInfoVo;
import com.yuwen.citysell.vo.ProdListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 *
 * @author 相柳
 * @date 2021/11/29
 */

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 产品列表
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return CommonResult<PageVo < ProdListVo>>
     */
    @GetMapping("/prod/list")
    public CommonResult<PageVo<ProdListVo>> list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        return CommonResult.success(productService.list(pageNum, pageSize));
    }

    @GetMapping("/prod/{id}")
    public CommonResult<ProdInfoVo> prodInfo(@PathVariable String id) {
        return CommonResult.success(productService.getProdInfo(id));
    }
}
