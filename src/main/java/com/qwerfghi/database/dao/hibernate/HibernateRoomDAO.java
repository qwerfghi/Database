package com.qwerfghi.database.dao.hibernate;

import com.qwerfghi.database.dao.RoomDAO;
import com.qwerfghi.database.entity.AnimalType;
import com.qwerfghi.database.entity.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class HibernateRoomDAO extends HibernateDAO<Room> implements RoomDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Room> getAllFreeRooms(AnimalType animalType, Date checkOutDate) {
        TypedQuery<Room> query = entityManager.createQuery("FROM Room r WHERE r.animalType = :animalType AND (r.dateEnd is NULL OR r.dateEnd > :checkOutDate)", Room.class);
        query.setParameter("animalType", animalType);
        query.setParameter("checkOutDate", checkOutDate);
        return query.getResultList();
    }

    @Override
    public Room getById(int id) {
        Room entity = new Room();
        entity.setCost(100);
        entityManager.persist(entity);
        return entityManager.find(Room.class, id);
    }

    @Override
    public List<Room> getAll() {
        return entityManager.createQuery("FROM Room", Room.class).getResultList();
    }
}