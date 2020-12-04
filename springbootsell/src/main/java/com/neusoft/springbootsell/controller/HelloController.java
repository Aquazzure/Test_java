package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloController {
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping("/")
    public List<ProductCategory> hello(){
        List<ProductCategory> list = productCategoryService.findAll();
        for(ProductCategory p:list){
            System.out.println(p);
        }
        return list;
    }
}
