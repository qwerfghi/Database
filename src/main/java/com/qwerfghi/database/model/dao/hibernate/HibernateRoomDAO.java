package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.RoomDAO;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class HibernateRoomDAO extends HibernateDAO<RoomEntity> implements RoomDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RoomEntity> getAllFreeRooms(AnimalType animalType, Date checkOutDate) {
        TypedQuery<RoomEntity> query = entityManager.createQuery("FROM RoomEntity r WHERE r.animalType = :animalType AND (r.dateEnd is NULL OR r.dateEnd > :checkOutDate)", RoomEntity.class);
        query.setParameter("animalType", animalType);
        query.setParameter("checkOutDate", checkOutDate);
        return query.getResultList();
    }

    @Override
    public RoomEntity getById(int id) {
        return entityManager.find(RoomEntity.class, id);
    }

    @Override
    public List<RoomEntity> getAll() {
        return entityManager.createQuery("FROM RoomEntity", RoomEntity.class).getResultList();
    }
}