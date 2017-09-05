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
//        PrivilegesEntity entity;
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
//            transaction = session.beginTransaction();
//            EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
//            byte b = 2;
//            entity = entityManager.find(PrivilegesEntity.class, b);
//            transaction.commit();
//            entityManager.close();
//            return entity;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            return null;
//        }

        return entityManager.find(PrivilegesEntity.class, 2);
    }

    @Override
    public PrivilegesEntity getById(int id) {
        return entityManager.find(PrivilegesEntity.class, id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public List<PrivilegesEntity> getAll() {
        return entityManager.createQuery("SELECT p FROM PrivilegesEntity p", PrivilegesEntity.class).getResultList();
    }
}