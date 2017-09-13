package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.PrivilegeDAO;
import com.qwerfghi.database.entity.Privileges;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernatePrivilegeDAO extends HibernateDAO<Privileges> implements PrivilegeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Privileges getUserPrivilege() {
        return entityManager.find(Privileges.class, 2);
    }

    @Override
    public Privileges getById(int id) {
        return entityManager.find(Privileges.class, id);
    }

    @Override
    public List<Privileges> getAll() {
        return entityManager.createQuery("FROM Privileges", Privileges.class).getResultList();
    }
}