package com.kaola.service;

import java.util.List;

import com.kaola.common.EasyUITreeNode;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:14:44 2017/10/26
 */
public interface ItemCatService {


    List<EasyUITreeNode> getItemCatList(long parentId);
}
