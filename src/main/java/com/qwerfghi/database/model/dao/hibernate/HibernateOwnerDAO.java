package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.OwnerDAO;
import com.qwerfghi.database.model.entity.OwnerEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HibernateOwnerDAO extends HibernateDAO<OwnerEntity> implements OwnerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OwnerEntity getById(int id) {
        return entityManager.find(OwnerEntity.class, id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public List<OwnerEntity> getAll() {
        return entityManager.createQuery("SELECT o FROM OwnerEntity o", OwnerEntity.class).getResultList();
    }
}