package com.service;

import com.dao.DutyDao;
import com.dao.impl.DutyDaoImpl;
import com.entity.Duty;

import java.util.List;

public class DutyService {
    DutyDao roleDao=new DutyDaoImpl();
    public List<Duty> queryRole(int role) {
        return roleDao.queryRole(role);
    }
}
