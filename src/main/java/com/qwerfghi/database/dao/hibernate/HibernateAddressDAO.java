package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.AddressDAO;
import com.qwerfghi.database.entity.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateAddressDAO extends HibernateDAO<Address> implements AddressDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address getById(int id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public List<Address> getAll() {
        return entityManager.createQuery("FROM Address", Address.class).getResultList();
    }
}