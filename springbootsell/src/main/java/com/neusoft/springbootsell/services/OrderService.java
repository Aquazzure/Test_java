package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OrderService {
    /**创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    /**查询单个订单*/
    OrderDTO findOne(String orderId);

    /**查询订单列表*/
    Page<OrderDetail> findList(Pageable pageable);

}
