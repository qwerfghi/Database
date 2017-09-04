package com.qwerfghi.database.model;

import com.qwerfghi.database.HibernateUtil;
import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import com.qwerfghi.database.model.entity.UserEntity;
import com.qwerfghi.database.model.entity.UserEntity_;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.*;

import static com.qwerfghi.database.controller.GuestWindowController.date;
import static com.qwerfghi.database.controller.GuestWindowController.select;

public class MyConnection {

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/hostel?autoReconnect=true&useSSL=false";
    private static String USER = "root";
    private static String PASS = "root";
    private Connection connection;
    private Statement statement;
    private Set<Room> rooms = new HashSet<>();
    private Set<FreeRoom> free_rooms = new HashSet<>();
    private Set<Information> information = new HashSet<>();
    private Set<Employeer> employeers = new HashSet<>();
    private Set<User> users = new HashSet<>();
    private Set<Animals> animals = new HashSet<>();
    private static int getted = 0;
    public static int currentId = 23;
    public static int userId = 23;
    public static AnimalType animalType;
    private Main app;
    public UserEntity user;

    public void setApp(Main app) {
        this.app = app;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close() throws SQLException {
        statement.close();
        connection.close();
        user = null;
    }

    public boolean logIn(String user, String password) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteria.from(UserEntity.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get(UserEntity_.username), user));
        criteria.where(builder.equal(root.get(UserEntity_.password), password));
        UserEntity entity = manager.createQuery(criteria).getSingleResult();
        manager.close();
        factory.close();
        return true;



        /*String sql = "select u.iduser, u.username, u.password as user_pass, p.privilege_name as privilege, p.password " +
                "from user as u " +
                "inner join privileges as p on u.privilege_id = p.id " +
                "where u.username = \'" + user + "\' and u.password = MD5(\'" + password + "\');";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                USER = resultSet.getString("privilege");
                PASS = resultSet.getString("password");
                int id = resultSet.getInt("iduser");
                String name = resultSet.getString("username");
                close();
                connect();
                this.user = new UserInfo(id, name);
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }*/
    }

    public boolean registration(String username, String pass, String firstName, String lastName, String patron,
                                String passN, String phoneN, String mail, String reg, String loc, String str,
                                String houseN, String appartN) {
        /*try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("insert into UserEntity (username, password, privilege_id)" +
                    "select username, password, privilege_id from UserEntity");

        }*/
        String sql = "insert into user (username, password, privilege_id) values (\'" + username + "\', MD5(\'" + pass + "\'), " + "2);";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Создаваемый пользователь уже существует.");
            return false;
        }
        idUser(username);
        String sql2 = "insert into owner (iduser, owner_name, owner_last_name, owner_patronymic, passport, phone_num, email, discount) values (" + user.getIduser() + ", " + firstName + ", " + lastName + ", " + patron + ", " + passN + ", " + phoneN + ", " + mail + ", '0%');";
        try {
            statement.execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        idOwner();
        String sql3 = "insert into address (idowner, region, locality, street, house_num, apartment_num) values (" + currentId + ", " + reg + ", " + loc + ", " + str + ", " + houseN + ", " + appartN + ");";
        try {
            statement.execute(sql3);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ObservableList<Room> getAllRooms() {
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(allRooms());
        return list;
    }

    private Set<Room> allRooms() {
        String sql = "select number, animal_type, date_beg, date_end, cost from room order by number asc";
        getted++;
        if (getted == 30) {
            Runtime.getRuntime().gc();
            System.out.println("Очистка");
            getted = 0;
        }
        rooms = getSet(getResultSet(sql));
        return rooms;
    }

    public ObservableList<Room> getAllSelectedRooms() {
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(allSelectedRooms());
        return list;
    }

    private Set<Room> allSelectedRooms() {
        String sql = "select number, date_beg, date_end, cost from room where animal_type='" + select + "' and (date_end<" + date + " or date_end is null) order by number asc;";
        getted++;
        if (getted == 30) {
            Runtime.getRuntime().gc();
            System.out.println("Очистка");
            getted = 0;
        }
        rooms = getSelectedRoomSet(getResultSet(sql));
        return rooms;
    }

    private ResultSet getResultSet(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Set<Room> getSet(ResultSet resultSet) {
        Set<Room> set = new LinkedHashSet<>();
        try {
            while (resultSet.next()) {
                String roomType = resultSet.getString("animal_type");
                String dateEnter = resultSet.getString("date_beg");
                Integer roomCost = resultSet.getInt("cost");
                Integer roomNum = resultSet.getInt("number");
                String dateOut = resultSet.getString("date_end");
                set.add(new Room(this, roomType, dateEnter, roomCost, roomNum, dateOut));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    private Set<Room> getSelectedRoomSet(ResultSet resultSet) {
        Set<Room> set = new LinkedHashSet<>();
        try {
            while (resultSet.next()) {
                Integer roomNum = resultSet.getInt("number");
                String dateEnter = resultSet.getString("date_beg");
                String dateOut = resultSet.getString("date_end");
                Integer roomCost = resultSet.getInt("cost");
                set.add(new Room(this, roomNum, dateEnter, dateOut, roomCost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
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

    public ObservableList<User> getAllUsers() {
        ObservableList<User> list = FXCollections.observableArrayList();
        list.addAll(allUsers());
        return list;
    }

    private Set<User> allUsers() {
        String sql = "select idowner, owner_name, owner_last_name, owner_patronymic, passport, phone_num, email, discount from owner;";
        getted++;
        if (getted == 30) {
            Runtime.getRuntime().gc();
            System.out.println("Очистка");
            getted = 0;
        }
        users = getUserSet(getResultSet(sql));
        return users;
    }

    private Set<User> getUserSet(ResultSet resultSet) {
        Set<User> set = new LinkedHashSet<>();
        try {
            while (resultSet.next()) {
                int idowner = resultSet.getInt("idowner");
                String name = resultSet.getString("owner_name");
                String lastName = resultSet.getString("owner_last_name");
                String patronymic = resultSet.getString("owner_patronymic");
                String passNum = resultSet.getString("passport");
                String phoneNum = resultSet.getString("phone_num");
                String email = resultSet.getString("email");
                String discount = resultSet.getString("discount");
                set.add(new User(this, idowner, name, lastName, patronymic, passNum, phoneNum, email, discount));
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
        String sql = "select idowner from owner where iduser = '" + user.getIduser() + "';";
        try {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                currentId = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addPet(String petN, String select_pet, int age, String notice) {
        String sql = "insert into animal (animal_name, animal_kind, vet_inspection, zootaxi, cut, idowner, age, notice) values (" + petN + ", " + select_pet + ", " + 0 + ", " + 0 + ", " + 0 + ", " + currentId + ", '" + age + "', '" + notice + "');";
        try {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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

    public ObservableList<Employeer> getAllEmployeers() {
        ObservableList<Employeer> list = FXCollections.observableArrayList();
        list.addAll(allEmployeers());
        return list;
    }

    private Set<Employeer> getEmployeersSet(ResultSet resultSet) {
        Set<Employeer> set = new LinkedHashSet<>();
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                String lName = resultSet.getString("employee_last_name");
                String pName = resultSet.getString("employee_patronymic");
                String dateN = resultSet.getString("date_rec");
                String position = resultSet.getString("position");
                String passport = resultSet.getString("passport");
                String phoneN = resultSet.getString("phone_num");
                String email = resultSet.getString("email");
                set.add(new Employeer(this, name, lName, pName, dateN, position, passport, phoneN, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    private Set<Employeer> allEmployeers() {
        String sql = "select * from staff;";
        getted++;
        if (getted == 30) {
            Runtime.getRuntime().gc();
            System.out.println("Очистка");
            getted = 0;
        }
        employeers = getEmployeersSet(getResultSet(sql));
        return employeers;
    }

    public boolean addEmployee(String firstName, String lastName, String patron, String Date, String position, String passN, String phoneN, String mail) {
        String sql = "insert into staff (employee_name, employee_last_name, employee_patronymic, date_rec, position, passport, phone_num, email) values ('" + firstName + "', '" + lastName + "', '" + patron + "', '" + Date + "', '" + position + "', '" + passN + "', '" + phoneN + "', '" + mail + "');";
        try {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteEmployee(String passport) {
        String sql = "DELETE FROM staff WHERE passport = '" + passport + "';";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public boolean addGuest(String firstName, String lastName, String patron, String passN, String phoneN, String mail) {
        String sql = "insert into owner (iduser, owner_name, owner_last_name, owner_patronymic, passport, phone_num, email, discount) values ('" + 24 + "', '" + firstName + "', '" + lastName + "', '" + patron + "', '" + passN + "', '" + phoneN + "', '" + mail + "', '0%');";
        try {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteGuest(Integer idowner) {
        int iduser = 0;
        String sql = "select iduser from owner where idowner = '" + idowner + "';";
        try {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                iduser = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (iduser == 24) {
            String sql1 = "DELETE FROM owner WHERE idowner='" + idowner + "';";
            try {
                statement.execute(sql1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql2 = "DELETE FROM user WHERE iduser='" + iduser + "';";
            try {
                statement.execute(sql2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateDis(int idowner, String discount) {
        String sql = "update owner set discount = '" + discount + "' where idowner = '" + idowner + "';";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Animals> getAllAnimals() {
        ObservableList<Animals> list = FXCollections.observableArrayList();
        list.addAll(allAnimals());
        return list;
    }

    private Set<Animals> allAnimals() {
        String sql = "select idowner, animal_name, animal_kind, age, notice from animal;";
        getted++;
        if (getted == 30) {
            Runtime.getRuntime().gc();
            System.out.println("Очистка");
            getted = 0;
        }
        animals = getAnimalsSet(getResultSet(sql));
        return animals;
    }

    private Set<Animals> getAnimalsSet(ResultSet resultSet) {
        Set<Animals> set = new LinkedHashSet<>();
        try {
            while (resultSet.next()) {
                Integer idOwner = resultSet.getInt("idowner");
                String animalName = resultSet.getString("animal_name");
                String animalType = resultSet.getString("animal_kind");
                Integer age = resultSet.getInt("age");
                String notice = resultSet.getString("notice");
                set.add(new Animals(this, idOwner, animalName, animalType, age, notice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    public boolean addPet(int idowner, String petN, String select_pet, int age, String notice) {
        String sql = "insert into animal (animal_name, animal_kind, vet_inspection, zootaxi, cut, idowner, age, notice) values ('" + petN + "', '" + select_pet + "', '" + 0 + "', '" + 0 + "', '" + 0 + "', '" + idowner + "', '" + age + "', '" + notice + "');";
        try {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deletePet(int idowner, String animalName, String animalType, int age) {
        String sql = "DELETE FROM animal WHERE idowner = '" + idowner + "' and animal_name = '" + animalName + "' and animal_kind = '" + animalType + "' and age = '" + age + "';";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}