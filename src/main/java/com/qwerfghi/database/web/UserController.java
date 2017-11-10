package com.qwerfghi.database.web;

import com.qwerfghi.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home")
    public String home(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = "/reservation")
    public String reservation(ModelMap model) {
        return "reservation";
    }

    @RequestMapping(value = "/rooms")
    public String rooms(ModelMap model) {
        return "rooms";
    }

    @RequestMapping(value = "/information")
    public String information(ModelMap model) {
        return "information";
    }
}