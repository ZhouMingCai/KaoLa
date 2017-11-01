package com.kaola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaola.common.EasyUIDataGridResult;
import com.kaola.dao.TbItemDao;
import com.kaola.pojo.TbItem;
import com.kaola.service.ItemService;

/**
 * Author:Zhoumc
 * Description:
 * DATA:18:15 2017/10/23
 */
@Service
public class ItemServiceImpl  implements ItemService{

    @Autowired
    private TbItemDao tbItemDao;
    @Override
    public TbItem getItemById(long itemId) {
        return tbItemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {

        PageHelper.startPage(page,rows);
        List<TbItem> list = tbItemDao.SelectBy();
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }
}
