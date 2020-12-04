package com.neusoft.springbootsell.repository;


import com.neusoft.springbootsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {;
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("老味居",10);
        ProductCategory category = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(category);
    }

    @Test
    public void delete(){
        productCategoryRepository.delete(4);
    }

}
