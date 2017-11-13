package com.kaola.order.service;


import com.kaola.common.utils.KLResult;
import com.kaola.order.service.pojo.OrderInfo;

public interface OrderService {

	KLResult createOrder(OrderInfo orderInfo);
}
