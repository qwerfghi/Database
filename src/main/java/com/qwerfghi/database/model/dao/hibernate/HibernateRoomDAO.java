package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.RoomDAO;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class HibernateRoomDAO implements RoomDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ObservableList<RoomEntity> getAllFreeRooms(AnimalType animalType, Date checkOutDate) {
//        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
//            Transaction transaction = session.beginTransaction();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<RoomEntity> criteriaQuery = builder.createQuery(RoomEntity.class);
//            Root<RoomEntity> entityRoot = criteriaQuery.from(RoomEntity.class);
//            criteriaQuery.select(entityRoot);
//            criteriaQuery.where(builder.and(builder.equal(entityRoot.get(RoomEntity_.animalType), type),
//                    builder.or(builder.isNull(entityRoot.get(RoomEntity_.dateEnd)),
//                            builder.lessThan(entityRoot.get(RoomEntity_.dateEnd), checkOutDate))));
//            criteriaQuery.orderBy(builder.asc(entityRoot.get(RoomEntity_.number)));
//            List<RoomEntity> resultList = session.createQuery(criteriaQuery).getResultList();
//            transaction.commit();
//            return FXCollections.observableArrayList(resultList);
//        }
        TypedQuery<RoomEntity> query = entityManager.createQuery("SELECT r FROM RoomEntity r WHERE r.animalType = :animalType AND (r.dateEnd is NULL OR r.dateEnd > :checkOutDate)", RoomEntity.class);
        query.setParameter("animalType", animalType);
        query.setParameter("checkOutDate", checkOutDate);
        return FXCollections.observableArrayList(query.getResultList());
    }

    @Override
    public void add(RoomEntity entity) {

    }

    @Override
    public RoomEntity getById(int id) {
        return null;
    }

    @Override
    public void update(RoomEntity entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<RoomEntity> getAll() {
        return null;
    }
}