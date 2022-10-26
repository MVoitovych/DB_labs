package com.lab4.service.impl;

import com.lab4.dao.DepartureDao;
import com.lab4.domain.Departure;
import com.lab4.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartureServiceImpl implements DepartureService {
    @Autowired
    private DepartureDao departureDao;

    @Override
    public List<Departure> findAll() {
        return departureDao.findAll();
    }

    @Override
    public Optional<Departure> findById(Integer integer) {
        return departureDao.findById(integer);
    }

    @Override
    public int create(Departure entity) {
        return departureDao.create(entity);
    }

    @Override
    public int update(Integer integer, Departure entity) {
        return departureDao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return departureDao.delete(integer);
    }
}
