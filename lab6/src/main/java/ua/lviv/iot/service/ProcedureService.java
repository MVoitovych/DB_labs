package ua.lviv.iot.service;

import ua.lviv.iot.domain.Firecar;

import java.util.Optional;

public interface ProcedureService {
    void callerInsert(String number);

    void cursor();

    void departureFiremanProcedure(Integer d_id, Integer f_id);

    void firecarProcedure(String mark);

    void getAvgFirecar();
}
