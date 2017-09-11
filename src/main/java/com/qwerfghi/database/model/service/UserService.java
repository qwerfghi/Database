package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.RoomDAO;
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

    @Transactional
    public List<RoomEntity> getAllFreeRooms(AnimalType animalType) {
        return roomDAO.getAllFreeRooms(animalType, null);
    }
}