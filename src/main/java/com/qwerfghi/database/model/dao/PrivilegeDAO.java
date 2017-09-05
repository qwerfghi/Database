package com.qwerfghi.database.model.dao;

import com.qwerfghi.database.model.entity.PrivilegesEntity;

public interface PrivilegeDAO extends Dao<PrivilegesEntity> {
    PrivilegesEntity getUserPrivilege();
}