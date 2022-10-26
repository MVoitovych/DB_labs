package com.lab4.service.impl;

import com.lab4.dao.FireCarDao;
import com.lab4.dao.FiremanDao;
import com.lab4.domain.Fireman;
import com.lab4.service.FiremanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiremanServiceImpl implements FiremanService {
    @Autowired
    private FiremanDao firemanDao;

    @Override
    public List<Fireman> findAll() {
        return firemanDao.findAll();
    }

    @Override
    public Optional<Fireman> findById(Integer integer) {
        return firemanDao.findById(integer);
    }

    @Override
    public int create(Fireman entity) {
        return firemanDao.create(entity);
    }

    @Override
    public int update(Integer integer, Fireman entity) {
        return firemanDao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return firemanDao.delete(integer);
    }
}
