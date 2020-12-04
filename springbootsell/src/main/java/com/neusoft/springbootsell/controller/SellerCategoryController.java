package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.form.CategoryForm;
import com.neusoft.springbootsell.services.ProductCategoryService;
import com.neusoft.springbootsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("seller/category")
public class SellerCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    ProductCategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> list = productCategoryService.findAll();
        for(ProductCategory productCategory:list){
            System.out.println(productCategory);
        }
        //将list添加到map中
        map.put("categoryList",list);
        return new ModelAndView("category/list",map);
    }

//    @GetMapping("/listByType")
//    public ModelAndView ListByCategoryType(Map<String,Object> map){
//
//    }

    //新增类目
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false)Integer categoryId,
                              Map<String, Object> map) {
        if(categoryId!=null){
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category",productCategory);
        }
        return new ModelAndView("category/index",map);
    }

    //类目保存
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "seller/category/list");
            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();
        try {
            if(form.getCategoryId()!=null){
                productCategory = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form,productCategory);
            categoryService.save(productCategory);
        } catch (Exception e) {
            map.put("msg",e.getMessage());
            map.put("url","seller/category/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }


}
