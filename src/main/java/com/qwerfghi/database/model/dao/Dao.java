package com.qwerfghi.database.model.dao;

import java.util.List;

public interface Dao<T> {
    void add(T entity);
    T getById(int id);
    void update(T entity);
    void delete (T entity);
    void deleteById(int id);
    List<T> getAll();
}