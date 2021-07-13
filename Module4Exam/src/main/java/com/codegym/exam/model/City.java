package com.codegym.exam.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @ManyToOne
    private Country country;
    @Min(1)
    private Double area;
    @Min(1)
    private Integer population;
    @Min(1)
    private Double gdp;
    private String description;
}

