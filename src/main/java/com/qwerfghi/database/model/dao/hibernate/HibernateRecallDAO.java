package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.entity.RecallEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateRecallDAO extends HibernateDAO<RecallEntity> implements RecallDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RecallEntity getById(int id) {
        return entityManager.find(RecallEntity.class, id);
    }

    @Override
    public List<RecallEntity> getAll() {
        return entityManager.createQuery("FROM RecallEntity", RecallEntity.class).getResultList();
    }
}