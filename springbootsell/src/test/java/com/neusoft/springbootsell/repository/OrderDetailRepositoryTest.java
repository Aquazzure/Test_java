package com.neusoft.springbootsell.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.neusoft.springbootsell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setOrderId("10001");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("11");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductQuantity(3);

        OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);

    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList=repository.findByOrderId("10003");
        System.out.println(orderDetailList);
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}