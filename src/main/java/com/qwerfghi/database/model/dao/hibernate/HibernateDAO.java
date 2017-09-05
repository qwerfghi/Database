package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.Dao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
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
}