package com.lab4.controller.impl;

import com.lab4.controller.DepartureFireCarController;
import com.lab4.dao.DepartureFireCarDao;
import com.lab4.domain.DepartureFireCar;
import com.lab4.service.DepartureFireCarService;
import com.lab4.service.impl.DepartureFireCarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartureFireCarControllerImpl implements DepartureFireCarController {
    @Autowired
    private DepartureFireCarService departureFireCarService;

    @Override
    public List<DepartureFireCar> findAll() {
        return departureFireCarService.findAll();
    }

    @Override
    public Optional<DepartureFireCar> findById(Integer integer, Integer integer2) {
        return departureFireCarService.findById(integer, integer2);
    }

    @Override
    public String create(DepartureFireCar entity) {
        return departureFireCarService.create(entity);
    }

    @Override
    public String update(Integer integer, Integer integer2, DepartureFireCar entity) {
        return departureFireCarService.update(integer, integer2, entity);
    }

    @Override
    public String delete(Integer integer, Integer integer2) {
        return departureFireCarService.delete(integer, integer2);
    }
}
