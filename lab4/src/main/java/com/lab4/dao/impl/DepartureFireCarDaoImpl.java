package com.lab4.dao.impl;

import com.lab4.dao.DepartureFireCarDao;
import com.lab4.domain.DepartureFireCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Repository
public class DepartureFireCarDaoImpl implements DepartureFireCarDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String FIND_ALL = "SELECT * FROM departure_firecar";
    private static final String CREATE = "INSERT departure_firecar(departure_id, firecar_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE departure_firecar SET departure_id=?, firecar_id=? " +
            "WHERE departure_id=? and firecar_id=?";
    private static final String DELETE = "DELETE FROM departure_firecar WHERE departure_id=? and firecar_id=?";
    private static final String FIND_BY_ID = "SELECT * FROM departure_firecar WHERE departure_id=? and firecar_id=?";

    @Override
    public List<DepartureFireCar> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(DepartureFireCar.class));
    }

    @Override
    public Optional<DepartureFireCar> findById(Integer departureId, Integer fireCarId) {
        Optional<DepartureFireCar> departureFireCar;
        try {
            departureFireCar = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(DepartureFireCar.class), departureId, fireCarId));
        } catch (EmptyResultDataAccessException e) {
            departureFireCar = Optional.empty();
        }
        return departureFireCar;
    }

    @Override
    public String create(DepartureFireCar entity) {
        jdbcTemplate.update(CREATE, entity.getDepartureId(), entity.getFireсarId());
        return ("departureId = " + entity.getDepartureId() + " fireCarId = " + entity.getFireсarId() + " was created");
    }

    @Override
    public String update(Integer departureId, Integer fireCarId, DepartureFireCar entity) {
        System.out.println("new departureId = " + entity.getDepartureId() + " new fireCarId = " + entity.getFireсarId());
        jdbcTemplate.update(UPDATE, entity.getDepartureId(), entity.getFireсarId(), departureId, fireCarId);
        return ("departureId = " + departureId + " fireCarId = " + fireCarId + " was updated");
    }

    @Override
    public String delete(Integer departureId, Integer fireCarId) {
        jdbcTemplate.update(DELETE, departureId, fireCarId);
        return ("departureId = " + departureId + " fireCarId = " + fireCarId + " was deleted");
    }
}
