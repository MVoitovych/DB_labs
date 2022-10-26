package com.lab4.dao.impl;

import com.lab4.dao.CallDao;
import com.lab4.domain.Call;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class CallDaoImpl implements CallDao {

    @Autowired
    private JdbcTemplate jdbcTemplate ;


    private static final String FIND_ALL = "SELECT * FROM `call`";
    private static final String CREATE = "INSERT `call`(departure_id, short_description) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE `call` SET departure_id=?, short_description=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `call` WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM `call` WHERE id=?";

    @Override
    public List<Call> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Call.class));
    }

    @Override
    public Optional<Call> findById(Integer id) {
        Optional<Call> call;
        try {
            call = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Call.class), id));
        } catch (EmptyResultDataAccessException e) {
            call = Optional.empty();
        }
        return call;
    }

    @Override
    public int create(Call call) {
        return jdbcTemplate.update(CREATE, call.getDepartureId(), call.getShort_description());
    }

    @Override
    public int update(Integer id, Call call) {
        return jdbcTemplate.update(UPDATE, call.getDepartureId(), call.getShort_description(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
