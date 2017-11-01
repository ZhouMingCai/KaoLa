package com.kaola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaola.common.EasyUITreeNode;
import com.kaola.service.ItemCatService;

/**
 * Author:Zhoumc
 * Description: 商品分类管理
 * DATA:15:06 2017/10/26
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name = "id" ,defaultValue = "0")Long parentId){
        List<EasyUITreeNode> treeNodes = itemCatService.getItemCatList(parentId);
        return treeNodes;
    }
}
