package com.kaola.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kaola.pojo.TbUser;

public interface TbUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    List<TbUser> queryByUser(@Param("userName") String userName,@Param("userPhone") String userPhone,@Param("userEmail") String userEmail);

    List<TbUser> queryUser(@Param("userName") String userName,@Param("password") String password);


}