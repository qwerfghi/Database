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
import java.util.Date;

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
        String roomNum = request.getParameter("roomNum");
        if (roomNum != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            try {
                String hiddenPet = request.getParameter("hiddenPet");
                Animal animal = getAnimal(user, hiddenPet);
                Date dateIn = dateFormat.parse(request.getParameter("dateIn"));
                Date dateOut = dateFormat.parse(request.getParameter("dateOut"));
                userService.reserveRoom(Integer.parseInt(roomNum), dateIn, dateOut, animal);
                model.addAttribute("freeRooms", userService.getAllFreeRooms(animal.getAnimalType()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String petName = request.getParameter("petName");
        if (petName != null) {
            Animal animal = getAnimal(user, petName);
            model.addAttribute("freeRooms", userService.getAllFreeRooms(animal.getAnimalType()));
        }
        return "user/reservation";
    }

    private Animal getAnimal(User user, String petName) {
        return user.getOwner()
                        .getAnimalList()
                        .stream()
                        .filter(animalEntity -> animalEntity.getAnimalName().equals(petName))
                        .findFirst()
                        .orElse(new Animal());
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