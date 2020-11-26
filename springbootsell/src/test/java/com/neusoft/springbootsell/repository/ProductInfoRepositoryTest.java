package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("老味居黄焖鸡米饭");
        productInfo.setProductPrice(new BigDecimal(9.88));
        productInfo.setProductStatus(100);
        productInfo.setProductDescription("非常香");

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);

    }
}
