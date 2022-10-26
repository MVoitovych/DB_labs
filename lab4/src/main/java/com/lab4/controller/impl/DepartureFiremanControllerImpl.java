package com.lab4.controller.impl;

import com.lab4.controller.DepartureFiremanController;
import com.lab4.dao.DepartureFiremanDao;
import com.lab4.domain.DepartureFireCar;
import com.lab4.domain.DepartureFireman;
import com.lab4.service.DepartureFiremanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartureFiremanControllerImpl implements DepartureFiremanController {
    @Autowired
    private DepartureFiremanService departureFiremanService;

    @Override
    public List<DepartureFireman> findAll() {
        return departureFiremanService.findAll();
    }

    @Override
    public Optional<DepartureFireman> findById(Integer integer, Integer integer2) {
        return departureFiremanService.findById(integer, integer2);
    }

    @Override
    public String create(DepartureFireman entity) {
        return departureFiremanService.create(entity);
    }

    @Override
    public String update(Integer integer, Integer integer2, DepartureFireman entity) {
        return departureFiremanService.update(integer, integer2, entity);
    }

    @Override
    public String delete(Integer integer, Integer integer2) {
        return departureFiremanService.delete(integer, integer2);
    }
}
