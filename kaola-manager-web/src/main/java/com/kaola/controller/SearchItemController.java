package com.kaola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaola.common.utils.KLResult;
import com.kaola.search.service.SearchItemService;

/**
 * Author:Zhoumc
 * Description:导入商品数据到索引库
 * DATA:14:40 2017/11/1
 */
@Controller
public class SearchItemController {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/index/item/import")
    @ResponseBody
    public KLResult importSearchItemList(){
        KLResult klResult = searchItemService.importAllSearchItems();
        return klResult;
    }

}
