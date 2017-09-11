package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.RoomDAO;
import com.qwerfghi.database.model.dao.UserDAO;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import com.qwerfghi.database.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class GuestService {

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public UserEntity getByUsernameAndPassword(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    @Transactional
    public List<RoomEntity> getAllFreeRooms(AnimalType type, Date checkInDate){
        return roomDAO.getAllFreeRooms(type, checkInDate);
    }
}