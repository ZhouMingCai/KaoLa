package com.kaola.search.service;

import com.kaola.common.pojo.SearchResult;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:11:24 2017/11/7
 */
public interface SearchService {

    SearchResult search(String keyword, int page, int rows)  throws Exception;
}
