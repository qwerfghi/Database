package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.RoomDAO;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class GuestService {

    @Autowired
    private RoomDAO roomDAO;

    @Transactional
    public ObservableList<RoomEntity> getAllFreeRooms(AnimalType type, Date checkInDate){
        return roomDAO.getAllFreeRooms(type, checkInDate);
    }
}
