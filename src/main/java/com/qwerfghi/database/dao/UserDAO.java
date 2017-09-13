package com.qwerfghi.database.dao;

import com.qwerfghi.database.entity.User;

public interface UserDAO extends Dao<User> {
    User getByUsernameAndPassword(String username, String password);
}