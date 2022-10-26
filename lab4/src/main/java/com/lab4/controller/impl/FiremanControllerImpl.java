package com.lab4.controller.impl;

import com.lab4.controller.FiremanController;
import com.lab4.dao.FiremanDao;
import com.lab4.domain.Fireman;
import com.lab4.service.FiremanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.Optional;

@Controller
public class FiremanControllerImpl implements FiremanController {
    @Autowired
    private FiremanService firemanService;

    @Override
    public List<Fireman> findAll() {
        return firemanService.findAll();
    }

    @Override
    public Optional<Fireman> findById(Integer integer) {
        return firemanService.findById(integer);
    }

    @Override
    public int create(Fireman entity) {
        return firemanService.create(entity);
    }

    @Override
    public int update(Integer integer, Fireman entity) {
        return firemanService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return firemanService.delete(integer);
    }
}
