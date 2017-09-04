package com.qwerfghi.database.model.dao;

import com.qwerfghi.database.model.entity.UserEntity;

public interface UserDAO {
    UserEntity getUser(String username, String password);
    void insertUser(UserEntity user);
}