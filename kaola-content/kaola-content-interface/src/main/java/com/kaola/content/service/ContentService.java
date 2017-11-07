package com.kaola.content.service;

import java.util.List;

import com.kaola.common.utils.KLResult;
import com.kaola.pojo.TbContent;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:10:03 2017/11/6
 */
public interface ContentService {

    KLResult addContent(TbContent content);

    List<TbContent> getContentListByCid(long cid);
}
