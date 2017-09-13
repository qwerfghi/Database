package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.AnimalDAO;
import com.qwerfghi.database.model.dao.RoomDAO;
import com.qwerfghi.database.model.entity.AnimalEntity;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private AnimalDAO animalDAO;

    @Transactional
    public List<RoomEntity> getAllFreeRooms(AnimalType animalType) {
        return roomDAO.getAllFreeRooms(animalType, null);
    }

    @Transactional
    public List<RoomEntity> getAllRooms() {
        return roomDAO.getAll();
    }

    @Transactional
    public void reserveRoom(RoomEntity roomEntity, AnimalEntity animalEntity) {
        roomDAO.update(roomEntity);
        animalDAO.update(animalEntity);
    }
}