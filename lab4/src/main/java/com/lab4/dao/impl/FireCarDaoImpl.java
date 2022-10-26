package com.lab4.dao.impl;

import com.lab4.dao.FireCarDao;
import com.lab4.domain.Departure;
import com.lab4.domain.FireCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Repository
public class FireCarDaoImpl implements FireCarDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String FIND_ALL = "SELECT * FROM firecar";
    private static final String CREATE = "INSERT firecar(mark) VALUES (?)";
    private static final String UPDATE = "UPDATE firecar SET mark=? WHERE id=?";
    private static final String DELETE = "DELETE FROM firecar WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM firecar WHERE id=?";

    @Override
    public List<FireCar> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(FireCar.class));
    }

    @Override
    public Optional<FireCar> findById(Integer id) {
        Optional<FireCar> fireCar;
        try {

            fireCar = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(FireCar.class), id));
        } catch (EmptyResultDataAccessException e) {
            fireCar = Optional.empty();
        }
        return fireCar;
    }

    @Override
    public int create(FireCar fireCar) {
        return jdbcTemplate.update(CREATE, fireCar.getMark());
    }

    @Override
    public int update(Integer id, FireCar fireCar) {
        return jdbcTemplate.update(UPDATE, fireCar.getMark(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
