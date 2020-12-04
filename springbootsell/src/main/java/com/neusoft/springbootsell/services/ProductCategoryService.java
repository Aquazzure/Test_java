package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    public ProductCategory findOne(Integer categoryId);

    public List<ProductCategory> findAll();

    public ProductCategory save(ProductCategory productCategory);

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    public void delete(Integer categoryId);
}