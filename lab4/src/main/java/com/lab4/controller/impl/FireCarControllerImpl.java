package com.lab4.controller.impl;

import com.lab4.controller.FireCarController;
import com.lab4.dao.FireCarDao;
import com.lab4.domain.FireCar;
import com.lab4.service.FireCarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class FireCarControllerImpl implements FireCarController {
    @Autowired
    private FireCarService fireCarService;

    @Override
    public List<FireCar> findAll() {
        return fireCarService.findAll();
    }

    @Override
    public Optional<FireCar> findById(Integer integer) {
        return fireCarService.findById(integer);
    }

    @Override
    public int create(FireCar entity) {
        return fireCarService.create(entity);
    }

    @Override
    public int update(Integer integer, FireCar entity) {
        return fireCarService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return fireCarService.delete(integer);
    }
}
