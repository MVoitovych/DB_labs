package com.lab4.dao.impl;

import com.lab4.dao.FireCarDao;
import com.lab4.dao.FiremanDao;
import com.lab4.domain.FireCar;
import com.lab4.domain.Fireman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Repository
public class FiremanDaoImpl implements FiremanDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final String FIND_ALL = "SELECT * FROM fireman";
    private static final String CREATE = "INSERT fireman(name, surname) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE fireman SET name=?, surname=? WHERE id=?";
    private static final String DELETE = "DELETE FROM fireman WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM fireman WHERE id=?";

    @Override
    public List<Fireman> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Fireman.class));
    }

    @Override
    public Optional<Fireman> findById(Integer id) {
        Optional<Fireman> fireman;
        try {

            fireman = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Fireman.class), id));
        } catch (EmptyResultDataAccessException e) {
            fireman = Optional.empty();
        }
        return fireman;
    }

    @Override
    public int create(Fireman fireman) {
        return jdbcTemplate.update(CREATE, fireman.getName(), fireman.getSurname());
    }

    @Override
    public int update(Integer id, Fireman fireman) {
        return jdbcTemplate.update(UPDATE, fireman.getName(), fireman.getSurname(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
