package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.HibernateUtil;
import com.qwerfghi.database.model.dao.AddressDAO;
import com.qwerfghi.database.model.entity.AddressEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;

public class HibernateAddressDAO implements AddressDAO {
    @Override
    public void insertAddress(AddressEntity addressEntity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
            entityManager.persist(addressEntity);
            entityManager.close();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
