package com.yuwen.citysell.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 相柳
 * @date 2021/11/30
 */
@Data
public class PageVo<T> {
    private List<T> records;
    private long total;
    private long size;
    private long current;
}
