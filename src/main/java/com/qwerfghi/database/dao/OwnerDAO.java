package com.qwerfghi.database.dao;

import com.qwerfghi.database.entity.Discount;
import com.qwerfghi.database.entity.Owner;

public interface OwnerDAO extends Dao<Owner> {
    void changeDiscount(int id, Discount discount);
}