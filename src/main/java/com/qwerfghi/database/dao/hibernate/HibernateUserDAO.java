package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.UserDAO;
import com.qwerfghi.database.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class HibernateUserDAO extends HibernateDAO<User> implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        TypedQuery<User> query = entityManager.createQuery("FROM User u WHERE u.username = :username AND u.password= :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}