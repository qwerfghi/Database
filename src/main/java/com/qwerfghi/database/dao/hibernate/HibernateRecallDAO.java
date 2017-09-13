package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.RecallDAO;
import com.qwerfghi.database.entity.Recall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateRecallDAO extends HibernateDAO<Recall> implements RecallDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Recall getById(int id) {
        return entityManager.find(Recall.class, id);
    }

    @Override
    public List<Recall> getAll() {
        return entityManager.createQuery("FROM Recall", Recall.class).getResultList();
    }
}