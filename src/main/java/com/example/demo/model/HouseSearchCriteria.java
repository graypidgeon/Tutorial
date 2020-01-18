package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class HouseSearchCriteria {
    private String name;
    private String description;
    private Integer areaFrom;
    private Integer areaTo;
    @Builder.Default
    private HouseOrderBy orderBy = HouseOrderBy.NAME;
}
