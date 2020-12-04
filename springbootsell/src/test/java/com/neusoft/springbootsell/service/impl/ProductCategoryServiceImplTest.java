package com.neusoft.springbootsell.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.services.impl.ProductCategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne(){
        ProductCategory productCategory = productCategoryService.findOne(3);
        System.out.println(productCategory);
        Assert.assertEquals(new Integer(3),productCategory.getCategoryId());
    }

    @Test
    public void findAll(){
        List<ProductCategory> list = productCategoryService.findAll();
        for(ProductCategory category:list){
            System.out.println(category);
        }
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryType(){
//        List<Integer> list= Arrays.asList(2,3,4);
        List<ProductCategory> list = productCategoryService.findByCategoryTypeIn(Arrays.asList(9,10));
        for(ProductCategory category:list){
            System.out.println(category);
        }
        Assert.assertNotEquals(3,list.size());
    }

    @Test
    public void save(){
        ProductCategory category = new ProductCategory("汉堡王",3);
        ProductCategory productCategory = productCategoryService.save(category);
        Assert.assertNotNull(productCategory);
    }


}
