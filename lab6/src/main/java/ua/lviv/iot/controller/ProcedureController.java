package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Firecar;
import ua.lviv.iot.dto.FirecarDto;
import ua.lviv.iot.dto.assembler.FirecarDtoAssembler;
import ua.lviv.iot.service.FirecarService;
import ua.lviv.iot.service.ProcedureService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/procedures")
public class ProcedureController {
    @Autowired
    private ProcedureService procedureService;
    @Autowired
    private FirecarService firecarService;
    @Autowired
    private FirecarDtoAssembler firecarDtoAssembler;

    @GetMapping("/callerInsert/{number}")
    public void callerInsert(@PathVariable String number) {
        procedureService.callerInsert(number);
    }

    @GetMapping("/cursor")
    public void cursor() {
        procedureService.cursor();
    }

    @GetMapping("/departureFiremanProcedure/{d_id}/{f_id}")
    public void departureFiremanProcedure(@PathVariable Integer d_id, @PathVariable Integer f_id) {
        procedureService.departureFiremanProcedure(d_id, f_id);
    }

    @GetMapping("/firecarProcedure/{mark}")
    public void firecarProcedure(@PathVariable String mark) {
        procedureService.firecarProcedure(mark);
    }

    @GetMapping("/getAvgFirecar")
    public String geAvgFirecar() {
        procedureService.getAvgFirecar();
        return "avg firecar was UPDATED";
    }


}
