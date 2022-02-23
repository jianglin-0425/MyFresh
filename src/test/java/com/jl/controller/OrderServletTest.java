package com.jl.controller;

import com.jl.bean.OrderInfo;
import com.jl.bean.OrderItemInfo;
import com.jl.biz.GoodsInfoBiz;
import com.jl.biz.OrderBiz;
import com.jl.biz.OrderItemBiz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class OrderServletTest {
    @Autowired
    OrderItemBiz itemBiz;
    @Autowired
    OrderBiz biz;
    @Autowired
    GoodsInfoBiz goodBiz;

     @Test
     void findOrdersTest(){
        OrderInfo order=new OrderInfo();
        order.setMno(1);
        Map<OrderInfo,List<OrderItemInfo>> result=new HashMap<>();
        try {
            List<OrderInfo> list=biz.getOrder(order);
            List<OrderItemInfo> orderItems=null;
            OrderItemInfo item=new OrderItemInfo();
            for (OrderInfo info:list) {
                item.setOno(info.getOno());
                orderItems=itemBiz.getOrderItem(item);
                result.put(info,orderItems);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void TestFindOrder() throws Exception {
        OrderItemInfo info=new OrderItemInfo();
        info.setOno("202005072026390411");
        System.out.println(itemBiz.getItemVO(info));;
     }

}