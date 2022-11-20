package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Firecar;

import java.util.Optional;

@Repository
public interface ProcedureRepository extends JpaRepository<Firecar, Integer> {
    @Procedure
    void CallerInsertProcedure(String phone_number);

    @Procedure
    void CursorProcedure();

    @Procedure
    void DepartureFiremanProcedure(Integer d_id , Integer f_id);

    @Procedure
    void FirecarProcedure(String mark);

    @Procedure
    void GetAvgFireCarProcedure();

}
