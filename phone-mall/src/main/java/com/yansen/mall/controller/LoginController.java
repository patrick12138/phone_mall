package com.yansen.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yansen.mall.entity.UserEntity;
import com.yansen.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login.html")
    public String loginPage(HttpSession session) {
        Object attribute = session.getAttribute("loginUser");
        if (attribute == null) {
            return "login";
        } else {
            return "redirect:/index.html";
        }
    }

    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (userService.login(username) != null) {
            if (password.equals(userService.login(username).getPassword())) {
                UserEntity user = userService.getOne(new QueryWrapper<UserEntity>().eq("username", username));
                session.setAttribute("loginUser", user);
                return "redirect:/index.html";
            }
        }
        return "redirect:/login.html";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/index.html";
    }

    @GetMapping("/reg.html")
    public String toReg() {
        return "reg";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("phone") String phone) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        userService.registUser(user);
        return "redirect:/login.html";
    }


}
