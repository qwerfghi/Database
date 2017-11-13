package com.qwerfghi.database.web;

import com.qwerfghi.database.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/pets")
    public String pets(ModelMap model) {
        return "admin/pets";
    }

    @RequestMapping(value = "/personal")
    public String personal(ModelMap model) {
        return "admin/personal";
    }

    @RequestMapping(value = "/visitors")
    public String visitors(ModelMap model) {
        return "admin/visitors";
    }
}