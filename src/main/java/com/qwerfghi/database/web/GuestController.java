package com.qwerfghi.database.web;

import com.qwerfghi.database.entity.*;
import com.qwerfghi.database.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("count")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/")
    public String index(ModelMap model) {
        model.addAttribute("count", 0);
        return "guest/index";
    }

    @GetMapping(value = "/guest")
    public String guest(ModelMap model, HttpServletRequest request) {
        String animalType = request.getParameter("animalType");
        String date = request.getParameter("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        List<Room> rooms = new ArrayList<>();
        try {
            Date parse = dateFormat.parse(date);
            rooms = guestService.getAllFreeRooms(AnimalType.fromCode(animalType), parse);
            System.out.println(guestService.getAllFreeRooms(AnimalType.fromCode(animalType), parse).size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("freeRooms", rooms);
        return "guest/guest";
    }

    @RequestMapping(value = "/signup")
    public String sighUp(ModelMap model, HttpServletRequest request, HttpSession session, @ModelAttribute(name = "count") int count) {
        switch (count) {
            case 0: {
                model.addAttribute("count", ++count);
                break;
            }
            case 1: {
                User user = new User();
                user.setUsername(request.getParameter("login"));
                user.setPassword(request.getParameter("password1"));
                Owner owner = new Owner();
                owner.setOwnerLastName(request.getParameter("lastName"));
                owner.setOwnerName(request.getParameter("name"));
                owner.setOwnerPatronymic(request.getParameter("patronymic"));
                session.setAttribute("user", user);
                session.setAttribute("owner", owner);
                model.addAttribute("count", ++count);
                break;
            }
            case 2: {
                Owner owner = (Owner) session.getAttribute("owner");
                owner.setPassport(request.getParameter("passport"));
                owner.setPhoneNum(request.getParameter("phoneNum"));
                owner.setEmail(request.getParameter("email"));
                Address address = new Address();
                address.setApartmentNum(Short.parseShort(request.getParameter("apartment")));
                address.setHouseNum(Byte.parseByte(request.getParameter("house")));
                address.setLocality(request.getParameter("locality"));
                address.setRegion(request.getParameter("region"));
                address.setStreet(request.getParameter("street"));
                guestService.addUser((User) session.getAttribute("user"), owner, address);
                session.setAttribute("owner", owner);
                model.addAttribute("count", ++count);
                break;
            }
            case 3: {
                Animal animal = new Animal();
                animal.setNotice(request.getParameter("notice"));
                animal.setAnimalName(request.getParameter("petName"));
                animal.setAge(Byte.parseByte(request.getParameter("petAge")));
                animal.setAnimalType(AnimalType.fromCode(request.getParameter("petType")));
                animal.setOwner((Owner) session.getAttribute("owner"));
                guestService.addAnimal(animal);
                break;
            }
        }
        return "guest/signup";
    }

    @RequestMapping(value = "/signin")
    public String signin(HttpSession session, @RequestParam("login") String login, @RequestParam("password") String password) {
        User user = guestService.getByUsernameAndPassword(login, password);
        if (user == null) {
            return "guest/index";
        } else {
            session.setAttribute("user", user);
            if (user.getPrivilegeEntity().getId() == 1) {
                return "redirect:/admin/pets";
            } else {
                return "redirect:/user/home";
            }
        }
    }
}