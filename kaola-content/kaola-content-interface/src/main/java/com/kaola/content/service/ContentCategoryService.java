package com.kaola.content.service;

import java.util.List;

import com.kaola.common.EasyUITreeNode;
import com.kaola.common.utils.KLResult;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:10:02 2017/11/6
 */

public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCatList(long parentId);

    KLResult addContentCategory(long parentId, String name);
}
