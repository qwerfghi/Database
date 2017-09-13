package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.StaffDAO;
import com.qwerfghi.database.entity.Staff;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateStaffDAO extends HibernateDAO<Staff> implements StaffDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Staff getById(int id) {
        return entityManager.find(Staff.class, id);
    }

    @Override
    public List<Staff> getAll() {
        return entityManager.createQuery("FROM Staff", Staff.class).getResultList();
    }
}