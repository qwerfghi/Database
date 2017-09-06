package com.qwerfghi.database.model.service;

import com.qwerfghi.database.model.dao.StaffDAO;
import com.qwerfghi.database.model.entity.StaffEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private StaffDAO staffDAO;

    @Transactional
    public List<StaffEntity> getAll() {
        return staffDAO.getAll();
    }
}
