package com.kaola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaola.common.utils.KLResult;
import com.kaola.content.spi.ContentService;
import com.kaola.pojo.TbContent;

/**
 * Author:Zhoumc
 * Description:内容管理
 * DATA:11:43 2017/11/6
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;


    @RequestMapping(value = "/content/save", method = RequestMethod.POST)
    @ResponseBody
    public KLResult  addContent(TbContent content){
        KLResult result = contentService.addContent(content);
        return result;
    }
}
