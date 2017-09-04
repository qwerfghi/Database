package com.qwerfghi.database.model.dao;

import com.qwerfghi.database.model.dao.hibernate.HibernateDAOFactory;
import com.qwerfghi.database.model.dao.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
    public static final int HIBERNATE = 1;
    public static final int JDBC = 2;

    public abstract RoomDAO getRoomDAO();
    public abstract UserDAO getUserDAO();
    public abstract PrivilegeDAO getPrivilegeDAO();
    public abstract AddressDAO getAddressDAO();
    public abstract OwnerDAO getOwnerDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case HIBERNATE:
                return new HibernateDAOFactory();
            case JDBC:
                return new JdbcDAOFactory();
            default:
                return new HibernateDAOFactory();
        }
    }
}