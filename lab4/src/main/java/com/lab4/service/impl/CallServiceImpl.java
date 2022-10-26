package com.lab4.service.impl;

import com.lab4.dao.CallDao;
import com.lab4.dao.impl.CallDaoImpl;
import com.lab4.domain.Call;
import com.lab4.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class CallServiceImpl implements CallService {
    @Autowired
    private CallDao callDao;

    @Override
    public List<Call> findAll() {
        return callDao.findAll();
    }

    @Override
    public Optional<Call> findById(Integer id) {
        return callDao.findById(id);
    }

    @Override
    public int create(Call entity) {
        return callDao.create(entity);
    }

    @Override
    public int update(Integer id, Call entity) {
        return callDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return callDao.delete(id);
    }
}
