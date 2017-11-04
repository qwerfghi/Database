package com.qwerfghi.database.web;

import com.qwerfghi.database.entity.AnimalType;
import com.qwerfghi.database.entity.Room;
import com.qwerfghi.database.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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

    @RequestMapping(value = "/index")
    public String index(ModelMap model) {
        if (!model.containsAttribute("count")) {
            model.addAttribute("count", 0);
        }
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
    public String sighUp(ModelMap model, HttpServletRequest request, HttpSession session, @ModelAttribute(name = "count") int count) {
        switch (count) {
            case 0:
                model.addAttribute("count", ++count);
                break;
            case 1:
                session.setAttribute("login", request.getAttribute("login"));
                session.setAttribute("password1", request.getAttribute("password1"));
                session.setAttribute("name", request.getAttribute("name"));
                session.setAttribute("lastName", request.getAttribute("lastName"));
                session.setAttribute("patronymic", request.getAttribute("patronymic"));
                model.addAttribute("count", ++count);
                break;
            case 2:
                session.setAttribute("email", request.getAttribute("email"));
                session.setAttribute("phoneNum", request.getAttribute("phoneNum"));
                session.setAttribute("passport", request.getAttribute("passport"));
                session.setAttribute("region", request.getAttribute("region"));
                session.setAttribute("locality", request.getAttribute("locality"));
                session.setAttribute("street", request.getAttribute("street"));
                session.setAttribute("house", request.getAttribute("house"));
                session.setAttribute("apartment", request.getAttribute("apartment"));
                model.addAttribute("count", ++count);
                break;
            case 3:

        }
        return "signup";
    }
}