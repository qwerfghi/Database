package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.AnimalDAO;
import com.qwerfghi.database.model.dao.OwnerDAO;
import com.qwerfghi.database.model.dao.StaffDAO;
import com.qwerfghi.database.model.entity.AnimalEntity;
import com.qwerfghi.database.model.entity.Discount;
import com.qwerfghi.database.model.entity.OwnerEntity;
import com.qwerfghi.database.model.entity.StaffEntity;
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

    @Transactional
    public OwnerEntity getOwnerById(int id) {
        return ownerDAO.getById(id);
    }

    @Transactional
    public void addAnimal(AnimalEntity entity) {
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
    public void deleteStaffById(int id) {
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
    public void addOwner (OwnerEntity entity) {
        ownerDAO.add(entity);
    }
}