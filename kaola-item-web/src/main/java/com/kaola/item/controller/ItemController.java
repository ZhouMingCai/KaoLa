package com.kaola.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaola.item.pojo.Item;
import com.kaola.pojo.TbItem;
import com.kaola.pojo.TbItemDesc;
import com.kaola.service.ItemService;

/**
 * Author:Zhoumc
 * Description:商品详情展示
 * DATA:17:33 2017/11/9
 */
@Controller
public class ItemController {


    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    public String showItemInfo(@PathVariable long itemId ,Model model){
        //调用服务商品信息
        TbItem tbItem =  itemService.getItemById(itemId);
        Item item = new Item(tbItem);
        //取商品描述
        TbItemDesc tbItemDesc = itemService.getItemDescById(itemId);
        model.addAttribute("item",item);
        model.addAttribute("itemDesc",tbItemDesc);
        return "item";

    }
}
