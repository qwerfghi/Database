package com.qwerfghi.database.model;

import com.qwerfghi.database.HibernateUtil;
import com.qwerfghi.database.Main;
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
import java.util.*;

public class MyConnection {

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/hostel?autoReconnect=true&useSSL=false";
    private static String USER = "root";
    private static String PASS = "root";
    private Connection connection;
    private Statement statement;
    private Set<Room> rooms = new HashSet<>();
    private Set<Information> information = new HashSet<>();
    private static int getted = 0;
    public static int currentId = 23;
    public static int userId = 23;
    public static AnimalType animalType;

    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getResultSet(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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

    public ObservableList<Information> getInformation() {
        ObservableList<Information> list = FXCollections.observableArrayList();
        list.addAll(information());
        return list;
    }

    private Set<Information> information() {
        String sql = "select owner_name, owner_last_name, owner_patronymic, passport, phone_num, email,\n" +
                " discount, region, locality, street, house_num, apartment_num, animal_name, animal_kind, age, notice from owner\n" +
                " inner join address on address.idowner = owner.idowner inner join animal on owner.idowner = animal.idowner where owner.idowner = " + currentId + ";";
        getted++;
        if (getted == 30) {
            Runtime.getRuntime().gc();
            System.out.println("Очистка");
            getted = 0;
        }
        information = getInformationSet(getResultSet(sql));
        return information;
    }

    private Set<Information> getInformationSet(ResultSet resultSet) {
        Set<Information> set = new LinkedHashSet<>();
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("owner_name");
                String lastName = resultSet.getString("owner_last_name");
                String patronymic = resultSet.getString("owner_patronymic");
                String passNum = resultSet.getString("passport");
                String phoneNum = resultSet.getString("phone_num");
                String email = resultSet.getString("email");
                String discount = resultSet.getString("discount");
                String region = resultSet.getString("region");
                String locality = resultSet.getString("locality");
                String street = resultSet.getString("street");
                Integer houseNum = resultSet.getInt("house_num");
                Integer apartNum = resultSet.getInt("apartment_num");
                String animalName = resultSet.getString("animal_name");
                String animalType = resultSet.getString("animal_kind");
                Integer age = resultSet.getInt("age");
                String notice = resultSet.getString("notice");
                set.add(new Information(this, name, lastName, patronymic, passNum, phoneNum, email, discount, region, locality, street, houseNum, apartNum, animalName, animalType, age, notice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    public void idUser(String login) {
        String sql = "select iduser from user where username = '" + login + "';";
        try {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                userId = result.getInt(1);
                idOwner();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void idOwner() {
        String sql = "select idowner from owner where iduser = '" + Main.getUser().getIduser() + "';";
        try {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                currentId = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> userPets() {
        String sql = "select animal_name from animal where idowner = '" + currentId + "';";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<String> list = new ArrayList<>();
            int i = 0;
            while (resultSet.next()) {
                list.add(i, resultSet.getNString(1));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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