package com.neusoft.springbootsell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neusoft.springbootsell.enums.OrderStatusEnum;
import com.neusoft.springbootsell.enums.PayStatusEnum;
import com.neusoft.springbootsell.utils.EnumUtil;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**订单主表*/
@Entity
@Data
public class OrderMaster {

    /**订单**/
    @Id
    private String orderId;

    /**买家名字 **/
    private String buyerName;

    /**卖家手机号**/
    private String buyerPhone;

    /**卖家地址**/
    private String buyerAddress;

    /**买家微信Openid*/
    private String buyerOpenid;

    /**订单金额*/
    private BigDecimal orderAmount;

    /**订单状态，默认为新下单*/
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    /**支付状态，默认为0未支付*/
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;

    @OneToMany(targetEntity = OrderDetail.class)
    List<OrderDetail> orderDetailList;//=new ArrayList<>();

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

}
