package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.AnimalDAO;
import com.qwerfghi.database.entity.Animal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateAnimalDAO extends HibernateDAO<Animal> implements AnimalDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Animal getById(int id) {
        return entityManager.find(Animal.class, id);
    }

    @Override
    public List<Animal> getAll() {
        return entityManager.createQuery("FROM Animal", Animal.class).getResultList();
    }
}