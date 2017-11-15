package com.qwerfghi.database.web;

import com.qwerfghi.database.entity.*;
import com.qwerfghi.database.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

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
    public String personal(ModelMap model, HttpServletRequest request) {
        String deleteId = request.getParameter("deleteId");
        String emplName = request.getParameter("emplName");
        if (deleteId != null) {
            adminService.deleteStaff(Integer.parseInt(deleteId));
        }
        if (emplName != null) {
            Staff staff = new Staff();
            staff.setEmployeeName(request.getParameter("emplName"));
            staff.setEmployeeLastName(request.getParameter("emplLastName"));
            staff.setEmployeePatronymic(request.getParameter("emplPatr"));
            staff.setPosition(request.getParameter("emplPosition"));
            staff.setPassport(request.getParameter("passNum"));
            staff.setPhoneNum(request.getParameter("phoneNum"));
            staff.setEmail(request.getParameter("email"));
            try {
                staff.setDateRec(new SimpleDateFormat("dd.mm.yyyy").parse(request.getParameter("date")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            adminService.addStaff(staff);
        }
        model.addAttribute("staff", adminService.getAllStaff());
        return "admin/personal";
    }

    @RequestMapping(value = "/visitors")
    public String visitors(ModelMap model, HttpServletRequest request) {
        String deleteId = request.getParameter("deleteId");
        String changeId = request.getParameter("changeId");
        String visitorName = request.getParameter("visitorName");
        if (deleteId != null) {
            adminService.deleteOwner(Integer.parseInt(deleteId));
        }
        if (changeId != null) {
            adminService.changeDiscount(Integer.parseInt(changeId), Discount.fromCode(request.getParameter("discount")));
        }
        if (visitorName != null) {
            Owner owner = new Owner();
            owner.setOwnerName(request.getParameter("visitorName"));
            owner.setOwnerLastName(request.getParameter("visitorLastName"));
            owner.setOwnerPatronymic(request.getParameter("visitorPatr"));
            owner.setPassport(request.getParameter("passNum"));
            owner.setPhoneNum(request.getParameter("phoneNum"));
            owner.setEmail(request.getParameter("email"));
            owner.setDiscount(Discount.ZERO);
            Address address = new Address();
            address.setStreet(request.getParameter("street"));
            address.setRegion(request.getParameter("region"));
            address.setLocality(request.getParameter("locality"));
            address.setApartmentNum(Integer.parseInt(request.getParameter("apartment")));
            address.setHouseNum(Integer.parseInt(request.getParameter("house")));
            adminService.addOwner(owner, address);
        }
        model.addAttribute("visitors", adminService.getAllOwners());
        return "admin/visitors";
    }
}