package com.dao;

import com.entity.Duty;

import java.util.List;

public interface DutyDao {
    List<Duty> queryRole(int role);
}
