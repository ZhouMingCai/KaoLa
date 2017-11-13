package com.kaola.cart.service;

import java.util.List;

import com.kaola.common.utils.KLResult;
import com.kaola.pojo.TbItem;

/**
 * Author:Zhoumc
 * Description:
 * DATA:10:49 2017/11/13
 */
public interface CartService {

    KLResult addCart(long userId, long itemId, int num);
    KLResult mergeCart(long userId, List<TbItem> itemList);
    List<TbItem> getCartList(long userId);
    KLResult updateCartNum(long userId, long itemId, int num);
    KLResult deleteCartItem(long userId, long itemId);
}
