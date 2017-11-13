package com.qwerfghi.database.web;

import com.qwerfghi.database.entity.User;
import com.qwerfghi.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home")
    public String home(ModelMap model) {
        return "user/home";
    }

    @RequestMapping(value = "/reservation")
    public String reservation(ModelMap model) {
        return "user/reservation";
    }

    @RequestMapping(value = "/rooms")
    public String rooms(ModelMap model) {
        model.addAttribute("rooms", userService.getAllRooms());
        return "user/rooms";
    }

    @RequestMapping(value = "/information")
    public String information(@ModelAttribute(name = "user") User user) {
        return "user/information";
    }
}