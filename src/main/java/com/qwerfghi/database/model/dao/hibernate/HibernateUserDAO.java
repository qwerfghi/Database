package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.HibernateUtil;
import com.qwerfghi.database.model.dao.UserDAO;
import com.qwerfghi.database.model.entity.PrivilegesEntity;
import com.qwerfghi.database.model.entity.UserEntity;
import com.qwerfghi.database.model.entity.UserEntity_;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class HibernateUserDAO implements UserDAO {

    @Override
    public UserEntity getUser(String username, String password) {
        UserEntity entity;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
            Root<UserEntity> root = criteria.from(UserEntity.class);
            criteria.select(root);
            criteria.where(builder.and(
                    builder.equal(root.get(UserEntity_.username), username),
                    builder.equal(root.get(UserEntity_.password), password)));
            entity = session.createQuery(criteria).getSingleResult();
            transaction.commit();
            return entity;
        } catch (NoResultException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertUser(UserEntity user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
            PrivilegesEntity entity = entityManager.find(PrivilegesEntity.class, 1L);
            user.setPrivilegeEntity(entity);
            entityManager.persist(user);
            entityManager.flush();
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