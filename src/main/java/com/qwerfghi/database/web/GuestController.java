package com.qwerfghi.database.web;

import com.qwerfghi.database.entity.AnimalType;
import com.qwerfghi.database.entity.Room;
import com.qwerfghi.database.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/index")
    public String index(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/guest")
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
        return "guest";
    }

    @RequestMapping(value = "/signup")
    public String sighUp(ModelMap model) {
        return "signup";
    }
}