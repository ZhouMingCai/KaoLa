package com.kaola.pojo;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaola.dao.TbItemDao;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:10:59 2017/10/26
 */
public class PageHelpTest {

    @Test
    public void PageHelpTest() throws  Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbItemDao itemDao = applicationContext.getBean(TbItemDao.class);
        PageHelper.startPage(1,10);

        List<TbItem> tbItem = itemDao.SelectBy();
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(tbItem);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(tbItem.size());


    }
}
