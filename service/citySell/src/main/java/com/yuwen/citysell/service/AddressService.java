package com.yuwen.citysell.service;

import com.yuwen.citysell.dto.AddrAddForm;
import com.yuwen.citysell.vo.AddrListVo;

import java.util.List;

/**
 * @author 相柳
 * @date 2021/11/17
 */
public interface AddressService {

    /**
     * 收货地址列表
     *
     * @return List<AddrListVo>
     */
    List<AddrListVo> addrList();

    /**
     * 新增收货地址
     *
     * @param addForm addForm
     */
    void add(AddrAddForm addForm);

    /**
     * 删除收货地址
     *
     * @param id id
     */
    void del(Long id);
}
