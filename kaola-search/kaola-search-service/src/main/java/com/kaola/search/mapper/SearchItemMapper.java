package com.kaola.search.mapper;

import java.util.List;

import com.kaola.common.pojo.SearchItem;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:15:30 2017/10/31
 */
public interface SearchItemMapper {

    List<SearchItem> getSearchItemList();

    SearchItem getItemById(long itemId);
}
