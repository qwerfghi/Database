package com.qwerfghi.database.dao;

import com.qwerfghi.database.entity.AnimalType;
import com.qwerfghi.database.entity.Room;

import java.util.Date;
import java.util.List;

public interface RoomDAO extends Dao<Room> {
    List<Room> getAllFreeRooms(AnimalType animalType, Date checkInDate);
}