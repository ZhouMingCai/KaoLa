package com.kaola.dao;


import java.util.List;

import com.kaola.pojo.TbItemCat;

public interface TbItemCatDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);

    List<TbItemCat> queryById(Long id);
}