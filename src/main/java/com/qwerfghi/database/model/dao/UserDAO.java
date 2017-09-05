package com.qwerfghi.database.model.dao;

import com.qwerfghi.database.model.entity.UserEntity;

public interface UserDAO extends Dao<UserEntity> {
    UserEntity getByUsernameAndPassword(String username, String password);
}