package com.dao.impl;

import com.dao.DutyDao;
import com.entity.Duty;
import com.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DutyDaoImpl implements DutyDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //通过roleId查询权限
    @Override
    public List<Duty> queryRole(int role) {
            String sql="select * from duty where roleId=?";
            return template.query(sql,new BeanPropertyRowMapper<>(Duty.class),role);
    }
}
