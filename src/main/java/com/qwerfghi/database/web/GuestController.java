package com.qwerfghi.database.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestController {

    @RequestMapping(value = "/index")
    public String helloWorld(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/guest")
    public String guest(ModelMap model) {
        return "guest";
    }
}