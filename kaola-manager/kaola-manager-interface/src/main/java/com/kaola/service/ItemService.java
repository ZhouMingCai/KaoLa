package com.kaola.service;

import com.kaola.common.EasyUIDataGridResult;
import com.kaola.common.utils.KLResult;
import com.kaola.pojo.TbItem;
import com.kaola.pojo.TbItemDesc;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:14:03 2017/10/24
 */
public interface ItemService {

    TbItem getItemById(long itemId);

    EasyUIDataGridResult  getItemList(int page,int rows);

    KLResult addItem(TbItem item ,String desc);

    TbItemDesc getItemDescById(long itemId);

}
