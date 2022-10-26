package com.lab4.controller.impl;

import com.lab4.controller.CallController;
import com.lab4.domain.Call;
import com.lab4.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Controller
public class CallControllerImpl implements CallController {
    @Autowired
    private CallService callService;

    @Override
    public List<Call> findAll() {
        return callService.findAll();
    }

    @Override
    public Optional<Call> findById(Integer integer) {
        return callService.findById(integer);
    }

    @Override
    public int create(Call entity) {
        return callService.create(entity);
    }

    @Override
    public int update(Integer integer, Call entity) {
        return callService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return callService.delete(integer);
    }
}
