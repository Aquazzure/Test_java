package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.Exception.SellException;
import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.dto.OrderDTO;
import com.neusoft.springbootsell.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 买家端订单
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    OrderService orderService;
    /**
     * 订单列表
     * @param page 第几页，从第一页开始
     * @param size 一页有多少条数据
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page" ,defaultValue="1") Integer page,
                             @RequestParam(value = "size",defaultValue = "5") Integer size,
                             Map<String,Object> map){
        //定义的接口从第一页开始，但是方法时从第0页开始的
        PageRequest request=new PageRequest(page-1,size);
        Page<OrderDetail> orderDetailPage=orderService.findList(request);
        map.put("orderDetailPage",orderDetailPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("order/list",map);
    }


    /**
     * 订单详情
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO=new OrderDTO();
        try{
            orderDTO=orderService.findOne(orderId);

        }catch (SellException e){
            log.error("【卖家端查询订单详情】 发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }

}
