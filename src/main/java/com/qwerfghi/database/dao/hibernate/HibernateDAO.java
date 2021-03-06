package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class HibernateDAO<T> implements Dao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }
}