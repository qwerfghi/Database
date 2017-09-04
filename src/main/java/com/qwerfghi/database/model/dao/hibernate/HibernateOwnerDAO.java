package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.HibernateUtil;
import com.qwerfghi.database.model.dao.OwnerDAO;
import com.qwerfghi.database.model.entity.OwnerEntity;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class HibernateOwnerDAO implements OwnerDAO {
    @Override
    @SuppressWarnings("all")
    public void insertOwner(OwnerEntity owner) {
        EntityTransaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(owner);
            entityManager.flush();
            entityManager.close();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
