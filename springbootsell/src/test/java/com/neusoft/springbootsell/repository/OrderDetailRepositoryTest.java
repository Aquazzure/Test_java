package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailReppository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setOrderId("10001");
        orderDetail.setProductId("Just1");
        orderDetail.setProductName("黄焖鸡");
        orderDetail.setProductPrice(new BigDecimal(10.88));
        orderDetail.setProductQuantity(2);

        OrderDetail detail = repository.save(orderDetail);
        Assert.assertNotNull(detail);
    }


}
