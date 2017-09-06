package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.UserDAO;
import com.qwerfghi.database.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class HibernateUserDAO extends HibernateDAO<UserEntity> implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity getByUsernameAndPassword(String username, String password) {
        TypedQuery<UserEntity> query = entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.username = :username AND u.password= :password", UserEntity.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    @Override
    public UserEntity getById(int id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Override
    public List<UserEntity> getAll() {
        return entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class).getResultList();
    }
}