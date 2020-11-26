package com.neusoft.springbootsell.service.impl;

import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.services.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne(){
        ProductInfo productInfo = productService.findOne("123");
//        System.out.println(productInfo);
        Assert.assertEquals("123",productInfo.getProductId());
    }

    @Test
    public void findAll(){
        List<ProductInfo> list= productService.findUpAll();
        for(ProductInfo info:list){
            System.out.println(info);
        }
    }


}
