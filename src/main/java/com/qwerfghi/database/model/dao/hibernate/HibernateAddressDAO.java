package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.AddressDAO;
import com.qwerfghi.database.model.entity.AddressEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HibernateAddressDAO extends HibernateDAO<AddressEntity> implements AddressDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AddressEntity getById(int id) {
        return entityManager.find(AddressEntity.class, id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public List<AddressEntity> getAll() {
        return entityManager.createQuery("SELECT a FROM AddressEntity a", AddressEntity.class).getResultList();
    }
}