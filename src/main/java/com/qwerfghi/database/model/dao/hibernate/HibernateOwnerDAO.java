package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.OwnerDAO;
import com.qwerfghi.database.model.entity.Discount;
import com.qwerfghi.database.model.entity.OwnerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateOwnerDAO extends HibernateDAO<OwnerEntity> implements OwnerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OwnerEntity getById(int id) {
        return entityManager.find(OwnerEntity.class, id);
    }

    @Override
    public List<OwnerEntity> getAll() {
        return entityManager.createQuery("SELECT o FROM OwnerEntity o JOIN FETCH o.address", OwnerEntity.class).getResultList();
    }

    @Override
    public void changeDiscount(int id, Discount discount) {
        getById(id).setDiscount(discount);
    }
}