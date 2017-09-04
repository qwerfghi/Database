package com.qwerfghi.database.model.dao;

import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import javafx.collections.ObservableList;

import java.util.Date;

public interface RoomDAO {
    /*int insertRoom(...);
    boolean deleteCustomer(...);
    RoomEntity findCustomer(...);
    boolean updateCustomer(...);
    RowSet selectCustomersRS(...);
    Collection selectCustomersTO(...);*/
    ObservableList<RoomEntity> getAllFreeRooms(AnimalType type, Date checkInDate);
}