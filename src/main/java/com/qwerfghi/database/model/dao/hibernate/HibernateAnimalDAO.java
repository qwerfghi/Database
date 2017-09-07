package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.AnimalDAO;
import com.qwerfghi.database.model.dao.Dao;
import com.qwerfghi.database.model.entity.AnimalEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateAnimalDAO extends HibernateDAO<AnimalEntity> implements AnimalDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AnimalEntity getById(int id) {
        return entityManager.find(AnimalEntity.class, id);
    }

    @Override
    public List<AnimalEntity> getAll() {
        return entityManager.createQuery("FROM AnimalEntity ", AnimalEntity.class).getResultList();
    }
}