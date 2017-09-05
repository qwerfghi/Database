package com.qwerfghi.database.model.dao;

import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;

import java.util.Date;
import java.util.List;

public interface RoomDAO extends Dao<RoomEntity> {
    List<RoomEntity> getAllFreeRooms(AnimalType animalType, Date checkInDate);
}