package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.PrivilegeDAO;
import com.qwerfghi.database.model.entity.PrivilegesEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HibernatePrivilegeDAO extends HibernateDAO<PrivilegesEntity> implements PrivilegeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PrivilegesEntity getUserPrivilege() {
        return entityManager.find(PrivilegesEntity.class, 2);
    }

    @Override
    public PrivilegesEntity getById(int id) {
        return entityManager.find(PrivilegesEntity.class, id);
    }

    @Override
    public List<PrivilegesEntity> getAll() {
        return entityManager.createQuery("FROM PrivilegesEntity", PrivilegesEntity.class).getResultList();
    }
}