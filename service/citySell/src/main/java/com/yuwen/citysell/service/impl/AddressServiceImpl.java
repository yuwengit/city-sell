package com.yuwen.citysell.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yuwen.citysell.common.IdGenerator;
import com.yuwen.citysell.dao.AddressMapper;
import com.yuwen.citysell.dto.AddrAddForm;
import com.yuwen.citysell.entity.Address;
import com.yuwen.citysell.service.AddressService;
import com.yuwen.citysell.vo.AddrListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 相柳
 * @date 2021/11/17
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private IdGenerator idGenerator;


    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddrListVo> addrList() {
        List<Address> addresses = addressMapper.selectList(Wrappers.<Address>query().eq("delete_status", "0"));
        return addresses.stream()
                .map(item ->
                        new AddrListVo(String.valueOf(item.getId()), item.getUsername(),
                                item.getPhone(), item.getShippingAddr(),
                                item.getDefaultFlag()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(AddrAddForm addForm) {
        Address record = new Address();
        record.setId(idGenerator.nextId());
        record.setUsername(addForm.getUsername());
        record.setPhone(addForm.getPhone());
        record.setShippingAddr(addForm.getShippingAddr());
        record.setDefaultFlag(addForm.getDefaultFlag());
        addressMapper.insert(record);
    }

    @Override
    public void del(Long id) {
        Address record = new Address();
        record.setId(id);
        record.setDeleteStatus(1);
        addressMapper.updateById(record);
    }
}
