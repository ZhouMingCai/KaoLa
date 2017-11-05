package com.kaola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaola.common.EasyUIDataGridResult;
import com.kaola.common.utils.KLResult;
import com.kaola.pojo.TbItem;
import com.kaola.service.ItemService;

/**
 * Author:Zhoumc
 * Description:
 * DATA:15:12 2017/10/24
 */
@Controller
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page ,Integer rows){
        EasyUIDataGridResult result = itemService.getItemList(page,rows);
        return result;
    }


    /**
     * 商品添加功能
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public KLResult addItem(TbItem item ,String desc){
        KLResult result = itemService.addItem(item,desc);
        return result;
    }
}

