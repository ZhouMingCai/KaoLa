package com.kaola.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaola.common.EasyUITreeNode;
import com.kaola.dao.TbItemCatDao;
import com.kaola.pojo.TbItemCat;
import com.kaola.service.ItemCatService;

/**
 * Author:Zhoumc
 * Description:商品分类管理
 * DATA:14:48 2017/10/26
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {


    @Autowired
    private TbItemCatDao tbItemCatDao;

    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        List<TbItemCat> list = tbItemCatDao.queryById(parentId);
        List<EasyUITreeNode> treeNodes = new ArrayList<>();
        for (TbItemCat itemCat : list){
            EasyUITreeNode node  = new EasyUITreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            node.setState(itemCat.getIsParent()?"closed":"open");
            treeNodes.add(node);
        }
        return treeNodes;
    }
}
