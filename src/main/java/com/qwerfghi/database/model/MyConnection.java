package com.qwerfghi.database.model;

import com.qwerfghi.database.HibernateUtil;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyConnection {

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/hostel?autoReconnect=true&useSSL=false";
    private static String USER = "root";
    private static String PASS = "root";
    private Connection connection;
    private Statement statement;
    public static int currentId = 23;
    public static AnimalType animalType;

    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRecall(String email, int mark, String recall) {
        String sql = "INSERT INTO recall (email, mark, recall) VALUES (" +
                "'" + email + "', " +
                "'" + mark + "', " +
                "'" + recall + "');";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void roomType(String name) {
        String sql = "select animal_kind from animal where idowner = '" + currentId + "' AND animal_name = '" + name + "';";
        try {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                if (result.getNString(1).equals("собака")) {
                    animalType = AnimalType.DOG;
                }
                if (result.getNString(1).equals("кот")) {
                    animalType = AnimalType.CAT;
                }
                if (result.getNString(1).equals("хомяк")) {
                    animalType = AnimalType.HAMSTER;
                }
                if (result.getNString(1).equals("черепаха")) {
                    animalType = AnimalType.TURTLE;
                }
                if (result.getNString(1).equals("змея")) {
                    animalType = AnimalType.SNAKE;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Set<FreeRoom> allFreeRooms() {
        List<RoomEntity> roomEntities;
        try (SessionFactory factory = HibernateUtil.getSessionFactory()) {
            Session session = factory.getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<RoomEntity> criteriaQuery = builder.createQuery(RoomEntity.class);
            Root<RoomEntity> entityRoot = criteriaQuery.from(RoomEntity.class);
            criteriaQuery.select(entityRoot);
            criteriaQuery.where(builder.equal(entityRoot.get("animalType"), animalType));
            roomEntities = session.createQuery(criteriaQuery).getResultList();
        }
        Set<FreeRoom> set = new HashSet<>();
        for (RoomEntity roomEntity : roomEntities) {
            set.add(new FreeRoom(roomEntity.getNumber(), roomEntity.getCost(), roomEntity.getAnimalType().toString()));
        }
        return set;
    }

    public ObservableList<FreeRoom> getAllFreeRooms() {
        ObservableList<FreeRoom> list = FXCollections.observableArrayList();
        list.addAll(allFreeRooms());
        return list;
    }

    public void addRes(String date_in, String date_out, int taxi, int cut, int vet, int number, String name) {
        String sql = "update room set idowner = '" + currentId + "', date_beg = '" + date_in + "', date_end ='" + date_out + "' where number = '" + number + "';";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "update animal set vet_inspection = '" + vet + "', zootaxi = '" + taxi + "', cut ='" + cut + "' where animal_name = '" + name + "' and idowner = '" + currentId + "';";
        try {
            statement.execute(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}