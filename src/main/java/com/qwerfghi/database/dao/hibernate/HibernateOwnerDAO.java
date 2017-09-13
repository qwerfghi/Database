package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.OwnerDAO;
import com.qwerfghi.database.entity.Discount;
import com.qwerfghi.database.entity.Owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateOwnerDAO extends HibernateDAO<Owner> implements OwnerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Owner getById(int id) {
        return entityManager.find(Owner.class, id);
    }

    @Override
    public List<Owner> getAll() {
        return entityManager.createQuery("SELECT o FROM Owner o JOIN FETCH o.address", Owner.class).getResultList();
    }

    @Override
    public void changeDiscount(int id, Discount discount) {
        getById(id).setDiscount(discount);
    }
}