package com.kaola.dao;


import java.util.List;

import com.kaola.pojo.TbItem;

public interface TbItemDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    List<TbItem> SelectBy();

    List<TbItem> queryByItemId(Long itemId);
}