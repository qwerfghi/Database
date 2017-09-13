package com.qwerfghi.database.service;

import com.qwerfghi.database.dao.*;
import com.qwerfghi.database.entity.*;
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
    public Owner getOwnerById(int id) {
        return ownerDAO.getById(id);
    }

    @Transactional
    public void addAnimal(Animal entity, int idOwner) {
        entity.setOwner(ownerDAO.getById(idOwner));
        animalDAO.add(entity);
    }

    @Transactional
    public void deleteAnimal(int id) {
        animalDAO.delete(id);
    }

    @Transactional
    public List<Animal> getAllAnimals() {
        return animalDAO.getAll();
    }

    @Transactional
    public List<Staff> getAllStaff() {
        return staffDAO.getAll();
    }

    @Transactional
    public void addStaff(Staff entity) {
        staffDAO.add(entity);
    }

    @Transactional
    public void deleteStaff(int id) {
        staffDAO.delete(id);
    }

    @Transactional
    public List<Owner> getAllOwners(){
        return ownerDAO.getAll();
    }

    @Transactional
    public void changeDiscount(int id, Discount discount) {
        ownerDAO.changeDiscount(id, discount);
    }

    @Transactional
    public void addOwner(Owner owner, Address address) {
        addressDAO.add(address);
        owner.setAddress(address);
        ownerDAO.add(owner);
    }

    @Transactional
    public void deleteOwner(int id) {
        ownerDAO.delete(id);
    }
}