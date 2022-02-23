package com.jl.demo;

import com.jl.bean.OrderItemInfo;
import com.jl.biz.OrderItemBiz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    OrderItemBiz biz;
    @Test
    void contextLoads() {
        OrderItemInfo info=new OrderItemInfo();
        info.setOno("");
        System.out.println(info);
        System.out.println(biz.getOrderItem(info));
    }

}
