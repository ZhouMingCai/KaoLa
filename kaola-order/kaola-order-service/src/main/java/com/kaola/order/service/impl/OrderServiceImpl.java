package com.kaola.order.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.kaola.common.jedis.JedisClient;
import com.kaola.common.utils.KLResult;
import com.kaola.dao.TbOrderDao;
import com.kaola.dao.TbOrderItemDao;
import com.kaola.dao.TbOrderShippingDao;
import com.kaola.order.service.OrderService;
import com.kaola.order.service.pojo.OrderInfo;
import com.kaola.pojo.TbOrderItem;
import com.kaola.pojo.TbOrderShipping;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:16:39 2017/11/13
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TbOrderDao orderDao;
    @Autowired
    private TbOrderItemDao orderItemDao;
    @Autowired
    private TbOrderShippingDao orderShippingDao;
    @Autowired
    private JedisClient jedisClient;

    @Value("${ORDER_ID_GEN_KEY}")
    private String ORDER_ID_GEN_KEY;
    @Value("${ORDER_ID_START}")
    private String ORDER_ID_START;
    @Value("${ORDER_DETAIL_ID_GEN_KEY}")
    private String ORDER_DETAIL_ID_GEN_KEY;

    @Override
    public KLResult createOrder(OrderInfo orderInfo) {
        //生成订单号。使用redis的incr生成。
        if (!jedisClient.exists(ORDER_ID_GEN_KEY)) {
            jedisClient.set(ORDER_ID_GEN_KEY, ORDER_ID_START);
        }
        String orderId = jedisClient.incr(ORDER_ID_GEN_KEY).toString();
        //补全orderInfo的属性
        orderInfo.setOrderId(orderId);
        //1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
        orderInfo.setStatus(1);
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        //插入订单表
        orderDao.insert(orderInfo);
        //向订单明细表插入数据。
        List<TbOrderItem> orderItems = orderInfo.getOrderItems();
        for (TbOrderItem tbOrderItem : orderItems) {
            //生成明细id
            String odId = jedisClient.incr(ORDER_DETAIL_ID_GEN_KEY).toString();
            //补全pojo的属性
            tbOrderItem.setId(odId);
            tbOrderItem.setOrderId(orderId);
            //向明细表插入数据
            orderItemDao.insert(tbOrderItem);
        }
        //向订单物流表插入数据
        TbOrderShipping orderShipping = orderInfo.getOrderShipping();
        orderShipping.setOrderId(orderId);
        orderShipping.setCreated(new Date());
        orderShipping.setUpdated(new Date());
        orderShippingDao.insert(orderShipping);
        //返回E3Result，包含订单号
        return KLResult.ok(orderId);
    }
}
