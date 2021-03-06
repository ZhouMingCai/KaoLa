package com.kaola.dao;


import java.util.List;

import com.kaola.pojo.TbContentCategory;

public interface TbContentCategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    TbContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);

    List<TbContentCategory> queryById(Long parentId);
}