package com.kaola.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Autheor: Zhoumc
 * @Description: 前台首页展示
 * @Date: 22:01 2017/11/05
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
