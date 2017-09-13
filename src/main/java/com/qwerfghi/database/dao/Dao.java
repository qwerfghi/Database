package com.qwerfghi.database.dao;

import java.util.List;

public interface Dao<T> {
    void add(T entity);
    T getById(int id);
    void update(T entity);
    void delete(int id);
    List<T> getAll();
}