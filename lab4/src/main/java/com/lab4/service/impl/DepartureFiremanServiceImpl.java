package com.lab4.service.impl;

import com.lab4.dao.DepartureFiremanDao;
import com.lab4.domain.DepartureFireCar;
import com.lab4.domain.DepartureFireman;
import com.lab4.service.DepartureFiremanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartureFiremanServiceImpl implements DepartureFiremanService {
    @Autowired
    private DepartureFiremanDao departureFiremanDao;

    @Override
    public List<DepartureFireman> findAll() {
        return departureFiremanDao.findAll();
    }

    @Override
    public Optional<DepartureFireman> findById(Integer integer, Integer integer2) {
        return departureFiremanDao.findById(integer, integer2);
    }

    @Override
    public String create(DepartureFireman entity) {
        return departureFiremanDao.create(entity);
    }

    @Override
    public String update(Integer integer, Integer integer2, DepartureFireman entity) {
        return departureFiremanDao.update(integer, integer2, entity);
    }

    @Override
    public String delete(Integer integer, Integer integer2) {
        return departureFiremanDao.delete(integer, integer2);
    }
}
