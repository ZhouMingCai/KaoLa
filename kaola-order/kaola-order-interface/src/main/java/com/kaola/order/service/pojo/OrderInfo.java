package com.kaola.order.service.pojo;

import java.io.Serializable;
import java.util.List;

import com.kaola.pojo.TbOrder;
import com.kaola.pojo.TbOrderItem;
import com.kaola.pojo.TbOrderShipping;

/**
 * Author:Zhoumc
 * Description:
 * DATA:16:11 2017/11/13
 */
public class OrderInfo  extends TbOrder implements Serializable{

    private List<TbOrderItem> orderItems;
    private TbOrderShipping orderShipping;


    public List<TbOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<TbOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public TbOrderShipping getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(TbOrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }
}
