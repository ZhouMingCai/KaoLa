package com.kaola.dao;


import java.util.List;

import com.kaola.pojo.TbContent;

public interface TbContentDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKeyWithBLOBs(TbContent record);

    int updateByPrimaryKey(TbContent record);

    List<TbContent> queryById(Long cid);
}