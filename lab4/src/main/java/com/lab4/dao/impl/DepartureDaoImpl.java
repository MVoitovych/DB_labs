package com.lab4.dao.impl;

import com.lab4.dao.DepartureDao;
import com.lab4.domain.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Repository
public class DepartureDaoImpl implements DepartureDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String FIND_ALL = "SELECT * FROM departure";
    private static final String CREATE = "INSERT departure(short_description) VALUES (?)";
    private static final String UPDATE = "UPDATE departure SET short_description=? WHERE id=?";
    private static final String DELETE = "DELETE FROM departure WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM departure WHERE id=?";


    @Override
    public List<Departure> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Departure.class));
    }

    @Override
    public Optional<Departure> findById(Integer id) {
        Optional<Departure> departure;
        try {

            departure = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Departure.class), id));
        } catch (EmptyResultDataAccessException e) {
            departure = Optional.empty();
        }
        return departure;
    }

    @Override
    public int create(Departure departure) {
        return jdbcTemplate.update(CREATE, departure.getShort_description());
    }

    @Override
    public int update(Integer id, Departure departure) {
        return jdbcTemplate.update(UPDATE, departure.getShort_description(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
