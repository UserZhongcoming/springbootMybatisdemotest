package com.zzw.springbootMybatisdemotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzw.springbootMybatisdemotest.entity.User;
import com.zzw.springbootMybatisdemotest.service.UserService;

@Controller
//@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(User user, Model model) {
        System.out.println("user:" + user);
        User user1 = userService.selectUser(user);
        System.out.println(user1);
        if (user1 == null) {
            model.addAttribute("msg", "用户名或密码错误,还有可能你还没注册！！！");
        } else {
            model.addAttribute("msg", "登陆成功！！！");
        }
        return "result";
    }

    @RequestMapping(value = "/register")
    public String register(User user, Model model) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~要注册的user:"
                + user + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        User user1 = userService.selectUserByUserName(user);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~查询到的" + user1
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (user1 == null) {
            userService.insertUser(user);
            model.addAttribute("msg", "注册成功！！！");
        } else {
            model.addAttribute("msg", "用户已存在！！！");
        }
        return "result";
    }
}
