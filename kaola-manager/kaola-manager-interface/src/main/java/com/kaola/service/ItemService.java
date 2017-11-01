package com.kaola.service;

import com.kaola.common.EasyUIDataGridResult;
import com.kaola.pojo.TbItem;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:14:03 2017/10/24
 */
public interface ItemService {

    TbItem getItemById(long itemId);

    EasyUIDataGridResult  getItemList(int page,int rows);



}
