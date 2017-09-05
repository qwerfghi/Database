package com.qwerfghi.database.model.dao;

import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import javafx.collections.ObservableList;

import java.util.Date;

public interface RoomDAO extends Dao<RoomEntity> {
    ObservableList<RoomEntity> getAllFreeRooms(AnimalType animalType, Date checkInDate);
}