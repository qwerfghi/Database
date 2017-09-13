package com.qwerfghi.database.dao;

import com.qwerfghi.database.entity.Privileges;

public interface PrivilegeDAO extends Dao<Privileges> {
    Privileges getUserPrivilege();
}