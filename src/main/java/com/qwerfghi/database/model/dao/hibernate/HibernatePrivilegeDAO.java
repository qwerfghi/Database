package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.HibernateUtil;
import com.qwerfghi.database.model.dao.PrivilegeDAO;
import com.qwerfghi.database.model.entity.PrivilegesEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernatePrivilegeDAO implements PrivilegeDAO {
    @Override
    public PrivilegesEntity getUserPrivilege() {
        PrivilegesEntity entity;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
            byte b = 2;
            entity = entityManager.find(PrivilegesEntity.class, b);
            transaction.commit();
            entityManager.close();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public void add(PrivilegesEntity entity) {

    }

    @Override
    public PrivilegesEntity getById(int id) {
        return null;
    }

    @Override
    public void update(PrivilegesEntity entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<PrivilegesEntity> getAll() {
        return null;
    }
}