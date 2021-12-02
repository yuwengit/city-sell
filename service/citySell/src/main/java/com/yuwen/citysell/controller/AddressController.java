package com.yuwen.citysell.controller;

import com.yuwen.citysell.dto.AddrAddForm;
import com.yuwen.citysell.service.AddressService;
import com.yuwen.citysell.vo.AddrListVo;
import com.yuwen.citysell.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收货地址
 *
 * @author 相柳
 * @date 2021/11/17
 */

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 收货地址列表
     *
     * @return
     */
    @GetMapping("/addr/list")
    public CommonResult<List<AddrListVo>> addrList() {
        return CommonResult.success(addressService.addrList());
    }

    /**
     * 新增收货地址
     *
     * @return CommonResult<Void>
     */
    @PostMapping("/addr/add")
    public CommonResult<Void> add(@RequestBody AddrAddForm addForm) {
        addressService.add(addForm);
        return CommonResult.success();
    }

    /**
     * 删除收货地址
     *
     * @return CommonResult<Void>
     */
    @GetMapping("/addr/del")
    public CommonResult<Void> del(Long id) {
        addressService.del(id);
        return CommonResult.success();
    }
}
