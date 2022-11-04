package com.voitovych.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartureFireCar {
    private Integer departureId;

    @Basic
    @Column(name = "fireсar_id")
    private Integer fireсarId;
}
