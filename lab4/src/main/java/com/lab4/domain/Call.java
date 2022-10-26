package com.lab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Call {
    private Integer id;
    private String short_description;
    private Integer departureId;
}
