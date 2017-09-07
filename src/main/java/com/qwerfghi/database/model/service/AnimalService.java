package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.AnimalDAO;
import com.qwerfghi.database.model.entity.AnimalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalDAO animalDAO;

    @Transactional
    public List<AnimalEntity> getAll() {
        return animalDAO.getAll();
    }
}
