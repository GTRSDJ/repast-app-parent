package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Order;
import com.aaa.lee.app.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.common.Mapper;


@Service
public class OrderService extends BaseService<Order> {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Mapper<Order> getMapper() {
        return orderMapper;
    }


    /**
     * 查询订单数据要与订单接口对接
     * @param
     * @return
     */
    public Order dosOrder(@RequestBody Order order){
        try {
            return super.selectOne(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
