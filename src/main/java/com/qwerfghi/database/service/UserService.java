package com.qwerfghi.database.service;

import com.qwerfghi.database.dao.AnimalDAO;
import com.qwerfghi.database.dao.RoomDAO;
import com.qwerfghi.database.entity.Animal;
import com.qwerfghi.database.entity.AnimalType;
import com.qwerfghi.database.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private AnimalDAO animalDAO;

    @Transactional
    public List<Room> getAllFreeRooms(AnimalType animalType) {
        return roomDAO.getAllFreeRooms(animalType, null);
    }

    @Transactional
    public List<Room> getAllRooms() {
        return roomDAO.getAll();
    }

    @Transactional
    public void reserveRoom(int number, Date dateBeg, Date dateEnd, Animal animal) {
        Room room = roomDAO.getRoomByNumber(number);
        room.setDateBeg(dateBeg);
        room.setDateEnd(dateEnd);
        roomDAO.update(room);
        animalDAO.update(animal);
    }
}