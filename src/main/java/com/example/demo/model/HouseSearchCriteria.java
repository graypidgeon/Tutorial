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
    @Builder.Default
    private HouseOrderBy orderBy = HouseOrderBy.NAME;
}
