package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.UserDAO;
import com.qwerfghi.database.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LoginService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public UserEntity getByUsernameAndPassword(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }
}