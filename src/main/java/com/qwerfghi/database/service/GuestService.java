package com.qwerfghi.database.service;

import com.qwerfghi.database.dao.*;
import com.qwerfghi.database.dao.RecallDAO;
import com.qwerfghi.database.entity.*;
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

    @Autowired
    private RecallDAO recallDAO;

    @Transactional
    public User getByUsernameAndPassword(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    @Transactional
    public List<Room> getAllFreeRooms(AnimalType type, Date checkInDate){
        return roomDAO.getAllFreeRooms(type, checkInDate);
    }

    @Transactional
    public void addUser(User user, Owner owner, Address address) {
        addressDAO.add(address);
        owner.setAddress(address);
        ownerDAO.add(owner);
        user.setPrivilegeEntity(privilegeDAO.getUserPrivilege());
        user.setOwner(owner);
        userDAO.add(user);
    }

    @Transactional
    public void addAnimal(Animal animal) {
        animalDAO.add(animal);
    }

    @Transactional
    public void addRecall(Recall entity) {
        recallDAO.add(entity);
    }
}