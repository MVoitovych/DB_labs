package com.lab4.service.impl;

import com.lab4.dao.DepartureFireCarDao;
import com.lab4.domain.DepartureFireCar;
import com.lab4.service.DepartureFireCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartureFireCarServiceImpl implements DepartureFireCarService {
    @Autowired
    private DepartureFireCarDao departureFireCarDao;

    @Override
    public List<DepartureFireCar> findAll() {
        return departureFireCarDao.findAll();
    }

    @Override
    public Optional<DepartureFireCar> findById(Integer integer, Integer integer2) {
        return departureFireCarDao.findById(integer, integer2);
    }

    @Override
    public String create(DepartureFireCar entity) {
        return departureFireCarDao.create(entity);
    }

    @Override
    public String update(Integer integer, Integer integer2, DepartureFireCar entity) {
        return departureFireCarDao.update(integer, integer2, entity);
    }

    @Override
    public String delete(Integer integer, Integer integer2) {
        return departureFireCarDao.delete(integer, integer2);
    }
}
