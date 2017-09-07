package com.qwerfghi.database.model.dao;

import com.qwerfghi.database.model.entity.Discount;
import com.qwerfghi.database.model.entity.OwnerEntity;

public interface OwnerDAO extends Dao<OwnerEntity> {
    void changeDiscount(int id, Discount discount);
}