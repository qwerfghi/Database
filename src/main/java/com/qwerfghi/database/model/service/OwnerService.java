package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.OwnerDAO;
import com.qwerfghi.database.model.entity.Discount;
import com.qwerfghi.database.model.entity.OwnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerDAO ownerDAO;

    @Transactional
    public OwnerEntity getById(int id) {
         return ownerDAO.getById(id);
    }

    @Transactional
    public List<OwnerEntity> getAll(){
        return ownerDAO.getAll();
    }

    @Transactional
    public void changeDiscount(int id, Discount discount) {
        ownerDAO.changeDiscount(id, discount);
    }
}