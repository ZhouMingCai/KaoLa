package kaola.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaola.common.utils.KLResult;
import com.kaola.pojo.TbUser;
import com.kaola.sso.service.RegisterService;

/**
 * @Autheor: Zhoumc
 * @Description: 注册功能
 * @Date: 23:43 2017/11/11
 */
@Controller
public class RegitsterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/page/register")
    public String showRegister() {
        return "register";
    }


    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public KLResult checkData(@PathVariable String param, @PathVariable Integer type) {
        KLResult e3Result = registerService.checkData(param, type);
        return e3Result;
    }

    @RequestMapping(value="/user/register", method= RequestMethod.POST)
    @ResponseBody
    public KLResult register(TbUser user) {
        KLResult result = registerService.register(user);
        return result;
    }
}
