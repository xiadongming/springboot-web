package com.example.demo.vo;


import java.util.List;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */
public class QueryResultVo<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;
}
