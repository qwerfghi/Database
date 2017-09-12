package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.*;
import com.qwerfghi.database.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AnimalDAO animalDAO;

    @Autowired
    private OwnerDAO ownerDAO;

    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private AddressDAO addressDAO;

    @Transactional
    public OwnerEntity getOwnerById(int id) {
        return ownerDAO.getById(id);
    }

    @Transactional
    public void addAnimal(AnimalEntity entity, int idOwner) {
        entity.setOwner(ownerDAO.getById(idOwner));
        animalDAO.add(entity);
    }

    @Transactional
    public void deleteAnimal(int id) {
        animalDAO.delete(id);
    }

    @Transactional
    public List<AnimalEntity> getAllAnimals() {
        return animalDAO.getAll();
    }

    @Transactional
    public List<StaffEntity> getAllStaff() {
        return staffDAO.getAll();
    }

    @Transactional
    public void addStaff(StaffEntity entity) {
        staffDAO.add(entity);
    }

    @Transactional
    public void deleteStaff(int id) {
        staffDAO.delete(id);
    }

    @Transactional
    public List<OwnerEntity> getAllOwners(){
        return ownerDAO.getAll();
    }

    @Transactional
    public void changeDiscount(int id, Discount discount) {
        ownerDAO.changeDiscount(id, discount);
    }

    @Transactional
    public void addOwner(OwnerEntity ownerEntity, AddressEntity addressEntity) {
        addressDAO.add(addressEntity);
        ownerEntity.setAddress(addressEntity);
        ownerDAO.add(ownerEntity);
    }

    @Transactional
    public void deleteOwner(int id) {
        ownerDAO.delete(id);
    }
}