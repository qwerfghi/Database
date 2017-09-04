package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.HibernateUtil;
import com.qwerfghi.database.model.dao.RoomDAO;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import com.qwerfghi.database.model.entity.RoomEntity_;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class HibernateRoomDAO implements RoomDAO {
    @Override
    public ObservableList<RoomEntity> getAllFreeRooms(AnimalType type, Date checkOutDate) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<RoomEntity> criteriaQuery = builder.createQuery(RoomEntity.class);
            Root<RoomEntity> entityRoot = criteriaQuery.from(RoomEntity.class);
            criteriaQuery.select(entityRoot);
            criteriaQuery.where(builder.and(builder.equal(entityRoot.get(RoomEntity_.animalType), type),
                    builder.or(builder.isNull(entityRoot.get(RoomEntity_.dateEnd)),
                            builder.lessThan(entityRoot.get(RoomEntity_.dateEnd), checkOutDate))));
            criteriaQuery.orderBy(builder.asc(entityRoot.get(RoomEntity_.number)));
            List<RoomEntity> resultList = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
            return FXCollections.observableArrayList(resultList);
        }
    }
}