package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.StaffDAO;
import com.qwerfghi.database.model.entity.StaffEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateStaffDAO extends HibernateDAO<StaffEntity> implements StaffDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StaffEntity getById(int id) {
        return entityManager.find(StaffEntity.class, id);
    }

    @Override
    public List<StaffEntity> getAll() {
        return entityManager.createQuery("FROM StaffEntity", StaffEntity.class).getResultList();
    }
}
