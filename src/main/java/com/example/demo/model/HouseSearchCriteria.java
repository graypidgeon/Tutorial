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
    private Integer usageAreaFrom;
    private Integer usageAreaTo;
    private Integer minWidth;
    private Integer minHeight;
    private Integer buildingAreaFrom;
    private Integer buildingAreaTo;
    private Storey storey;
    @Builder.Default
    private HouseOrderBy orderBy = HouseOrderBy.NAME;
}
