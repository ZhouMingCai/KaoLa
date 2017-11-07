package com.kaola.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaola.common.EasyUITreeNode;
import com.kaola.common.utils.KLResult;
import com.kaola.content.service.ContentCategoryService;
import com.kaola.dao.TbContentCategoryDao;
import com.kaola.pojo.TbContentCategory;

/**
 * Author:Zhoumc
 * Description:内容分类管理
 * DATA:10:05 2017/11/6
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {


    @Autowired
    private TbContentCategoryDao categoryDao;

    @Override
    public List<EasyUITreeNode> getContentCatList(long parentId) {
        List<TbContentCategory> categoryList = categoryDao.queryById(parentId);
        List<EasyUITreeNode> nodeList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : categoryList){
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            nodeList.add(node);
        }
        return nodeList;
    }

    @Override
    public KLResult addContentCategory(long parentId, String name) {
        TbContentCategory category = new TbContentCategory();
        category.setParentId(parentId);
        category.setName(name);
        //1：正常 2：删除
        category.setStatus(1);
        //默认排除为1
        category.setSortOrder(1);
        category.setCreated(new Date());
        category.setUpdated(new Date());

        categoryDao.insert(category);
        TbContentCategory parent = categoryDao.selectByPrimaryKey(parentId);
        if (!parent.getIsParent()) {
            parent.setIsParent(true);
            //更新到数数据库
            categoryDao.updateByPrimaryKey(parent);
        }
        return KLResult.ok(category);
    }
}
