package com.qwerfghi.database.web;

import com.qwerfghi.database.entity.Animal;
import com.qwerfghi.database.entity.AnimalType;
import com.qwerfghi.database.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/pets")
    public String pets(ModelMap model, HttpServletRequest request) {
        String deleteId = request.getParameter("deleteId");
        String addId = request.getParameter("addId");
        if (deleteId != null) {
            adminService.deleteAnimal(Integer.parseInt(deleteId));
        }
        if (addId != null) {
            Animal animal = new Animal();
            animal.setAnimalName(request.getParameter("petName"));
            animal.setAnimalType(AnimalType.fromCode(request.getParameter("petType")));
            animal.setAge(Byte.parseByte(request.getParameter("petAge")));
            animal.setNotice(request.getParameter("notice"));
            adminService.addAnimal(animal, Integer.parseInt(addId));
        }
        model.addAttribute("pets", adminService.getAllAnimals());
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