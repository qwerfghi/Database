package com.qwerfghi.database.web;

import com.qwerfghi.database.entity.Animal;
import com.qwerfghi.database.entity.User;
import com.qwerfghi.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home")
    public String home() {
        return "user/home";
    }

    @RequestMapping(value = "/reservation")
    public String reservation(ModelMap model, @ModelAttribute(name = "user") User user, HttpServletRequest request) {
        String petName = request.getParameter("petName");
        String roomNum = request.getParameter("roomNum");
        if (petName != null) {
            Animal animal = user.getOwner()
                    .getAnimalList()
                    .stream()
                    .filter(animalEntity -> animalEntity.getAnimalName().equals(petName))
                    .findFirst()
                    .orElse(new Animal());
             model.addAttribute("freeRooms", userService.getAllFreeRooms(animal.getAnimalType()));
        }
        if (roomNum != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            try {
                userService.reserveRoom(Integer.parseInt(roomNum), dateFormat.parse(request.getParameter("dateIn")),
                        dateFormat.parse(request.getParameter("dateOut")), null /*animal*/);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
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