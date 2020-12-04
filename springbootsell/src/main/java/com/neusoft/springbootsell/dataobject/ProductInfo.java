package com.neusoft.springbootsell.dataobject;

import com.neusoft.springbootsell.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
商品详情
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    /** 商品Id*/
    @Id
    private String productId;

    /** 商品名称*/
    private String productName;

    /** 单价*/
    private BigDecimal productPrice;

    /** 库存*/
    private Integer productStock;

    /** 描述*/
    private String productDescription;

    /** 小图*/
    private String productIcon;

    /** 状态 0正常 1下架*/
    private Integer productStatus= ProductStatusEnum.UP.getCode();

    /** 类目编号*/
    private Integer categoryType;

    /** 创建时间*/
    @Column(name = "create_time",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;

    /** 更新时间*/
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateTime;

}
