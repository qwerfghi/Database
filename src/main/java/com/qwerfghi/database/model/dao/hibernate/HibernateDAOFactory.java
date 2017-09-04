package com.qwerfghi.database.model.dao.hibernate;

import com.qwerfghi.database.model.dao.*;

public class HibernateDAOFactory extends DAOFactory {
    @Override
    public RoomDAO getRoomDAO() {
        return new HibernateRoomDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new HibernateUserDAO();
    }

    @Override
    public PrivilegeDAO getPrivilegeDAO() {
        return new HibernatePrivilegeDAO();
    }

    @Override
    public AddressDAO getAddressDAO() {
        return new HibernateAddressDAO();
    }

    @Override
    public OwnerDAO getOwnerDAO() {
        return new HibernateOwnerDAO();
    }
}