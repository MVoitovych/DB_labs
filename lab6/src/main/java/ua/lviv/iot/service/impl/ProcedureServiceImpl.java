package ua.lviv.iot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Firecar;
import ua.lviv.iot.repository.ProcedureRepository;
import ua.lviv.iot.service.ProcedureService;

import java.util.Optional;

@Service
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public void callerInsert(String number) {
        procedureRepository.CallerInsertProcedure(number);
    }

    @Override
    public void cursor() {
        procedureRepository.CursorProcedure();
    }

    @Override
    public void departureFiremanProcedure(Integer d_id, Integer f_id) {
        procedureRepository.DepartureFiremanProcedure(d_id, f_id);
    }

    @Override
    public void firecarProcedure(String mark) {
        procedureRepository.FirecarProcedure(mark);
    }

    @Override
    public void getAvgFirecar() {
        procedureRepository.GetAvgFireCarProcedure();
    }
}
