package com.neusoft.springbootsell.form;

import lombok.Data;

@Data

public class CategoryForm {
    //类目id
    private Integer categoryId;
    //类目的名字
    private String categoryName;
    //类目的编号
    private Integer categoryType;
}