package com.lab4.controller.impl;

import com.lab4.controller.DepartureController;
import com.lab4.dao.DepartureDao;
import com.lab4.domain.Departure;
import com.lab4.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartureControllerImpl implements DepartureController {
    @Autowired
    private DepartureService departureService;

    @Override
    public List<Departure> findAll() {
        return departureService.findAll();
    }

    @Override
    public Optional<Departure> findById(Integer integer) {
        return departureService.findById(integer);
    }

    @Override
    public int create(Departure entity) {
        return departureService.create(entity);
    }

    @Override
    public int update(Integer integer, Departure entity) {
        return departureService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return departureService.delete(integer);
    }
}
