package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.*;
import com.qwerfghi.database.model.entity.*;
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

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private OwnerDAO ownerDAO;

    @Autowired
    private PrivilegeDAO privilegeDAO;

    @Autowired
    private AnimalDAO animalDAO;

    @Transactional
    public UserEntity getByUsernameAndPassword(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    @Transactional
    public List<RoomEntity> getAllFreeRooms(AnimalType type, Date checkInDate){
        return roomDAO.getAllFreeRooms(type, checkInDate);
    }

    @Transactional
    public void addUser(UserEntity userEntity, OwnerEntity ownerEntity, AddressEntity addressEntity) {
        addressDAO.add(addressEntity);
        ownerEntity.setAddress(addressEntity);
        ownerDAO.add(ownerEntity);
        userEntity.setPrivilegeEntity(privilegeDAO.getUserPrivilege());
        userEntity.setOwnerEntity(ownerEntity);
        userDAO.add(userEntity);
    }

    @Transactional
    public void addAnimal(AnimalEntity animalEntity) {
        animalDAO.add(animalEntity);
    }
}