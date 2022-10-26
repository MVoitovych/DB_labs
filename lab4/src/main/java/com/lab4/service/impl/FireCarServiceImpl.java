package com.lab4.service.impl;

import com.lab4.dao.FireCarDao;
import com.lab4.domain.FireCar;
import com.lab4.service.FireCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FireCarServiceImpl implements FireCarService {
    @Autowired
    private FireCarDao fireCarDao;

    @Override
    public List<FireCar> findAll() {
        return fireCarDao.findAll();
    }

    @Override
    public Optional<FireCar> findById(Integer integer) {
        return fireCarDao.findById(integer);
    }

    @Override
    public int create(FireCar entity) {
        return fireCarDao.create(entity);
    }

    @Override
    public int update(Integer integer, FireCar entity) {
        return fireCarDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return fireCarDao.delete(integer);
    }
}
