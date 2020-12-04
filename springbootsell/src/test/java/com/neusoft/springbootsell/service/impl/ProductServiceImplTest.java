package com.neusoft.springbootsell.service.impl;

import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.enums.ProductStatusEnum;
import com.neusoft.springbootsell.services.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne(){
        ProductInfo productInfo = productService.findOne("123");
        System.out.println(productInfo);
        Assert.assertEquals("123",productInfo.getProductId());
    }

    @Test
    public void findUpAll(){
        List<ProductInfo> list= productService.findUpAll();
        for(ProductInfo info:list){
            System.out.println(info);
        }
    }

    @Test
    public void findAll(){
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        Assert.assertEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234");
        productInfo.setProductName("麻辣烫");
        productInfo.setProductPrice(new BigDecimal(15));
        productInfo.setProductStock(2323);
        productInfo.setProductDescription("老好吃了");
        productInfo.setProductId("http");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo res = productService.save(productInfo);
        Assert.assertNotNull(res);
    }

    @Test
    public void onSale(){
        ProductInfo sale = productService.onSale("1234");
        Assert.assertEquals(ProductStatusEnum.DOWN.getCode(),sale.getProductStatus());
    }

    @Test
    public void offSale(){
        ProductInfo sale = productService.offSale("1234");
        Assert.assertEquals(ProductStatusEnum.UP.getCode(),sale.getProductStatus());
    }



}
