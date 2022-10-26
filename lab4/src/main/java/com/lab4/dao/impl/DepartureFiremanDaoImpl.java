package com.lab4.dao.impl;

import com.lab4.dao.DepartureFiremanDao;
import com.lab4.domain.DepartureFireman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Repository
public class DepartureFiremanDaoImpl implements DepartureFiremanDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String FIND_ALL = "SELECT * FROM departure_fireman";
    private static final String CREATE = "INSERT departure_fireman(departure_id, fireman_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE departure_fireman SET departure_id=?, fireman_id=? " +
            "WHERE departure_id=? and fireman_id=?";
    private static final String DELETE = "DELETE FROM departure_fireman WHERE departure_id=? and fireman_id=?";
    private static final String FIND_BY_ID = "SELECT * FROM departure_fireman WHERE departure_id=? and fireman_id=?";

    @Override
    public List<DepartureFireman> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(DepartureFireman.class));
    }

    @Override
    public Optional<DepartureFireman> findById(Integer departureId, Integer fireCarId) {
        Optional<DepartureFireman> departureFireman;
        try {
            departureFireman = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(DepartureFireman.class), departureId, fireCarId));
        } catch (EmptyResultDataAccessException e) {
            departureFireman = Optional.empty();
        }
        return departureFireman;
    }

    @Override
    public String create(DepartureFireman entity) {
        jdbcTemplate.update(CREATE, entity.getDepartureId(), entity.getFiremanId());
        return ("departureId = " + entity.getDepartureId() + " fireCarId = " + entity.getFiremanId() + " was deleted");
    }

    @Override
    public String update(Integer departureId, Integer fireManId, DepartureFireman entity) {
        System.out.println("new departureId = " + entity.getDepartureId() + " new fireMan = " + entity.getFiremanId());
        jdbcTemplate.update(UPDATE, entity.getDepartureId(), entity.getFiremanId(), departureId, fireManId);
        return ("departureId = " + departureId + " fireCarId = " + fireManId + " was updated");
    }

    @Override
    public String delete(Integer departureId, Integer firemanId) {
        jdbcTemplate.update(DELETE, departureId, firemanId);
        return ("departureId = " + departureId + " firemanId = " + firemanId + " was deleted");
    }
}
