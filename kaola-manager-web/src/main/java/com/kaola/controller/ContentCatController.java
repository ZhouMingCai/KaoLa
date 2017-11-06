package com.kaola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaola.common.EasyUITreeNode;
import com.kaola.common.utils.KLResult;
import com.kaola.content.spi.ContentCategoryService;

/**
 * Author:Zhoumc
 * Description:内容分类管理
 * DATA:10:27 2017/11/6
 */

@Controller("/content")
public class ContentCatController {

    @Autowired
    private ContentCategoryService categoryService;

    @RequestMapping("/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentList(@RequestParam(name = "id",defaultValue = "0")Long parentId){
        List<EasyUITreeNode> nodeList = categoryService.getContentCatList(parentId);
        return nodeList;
    }


    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    @ResponseBody
    public KLResult createContentCategory(Long parentId , String name){
        KLResult result = categoryService.addContentCategory(parentId,name);
        return  result;
    }
}
