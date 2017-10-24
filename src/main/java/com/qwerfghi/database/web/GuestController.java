package com.qwerfghi.database.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestController {

    @RequestMapping(value = "/")
    public String helloWorld(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "index";
    }
}