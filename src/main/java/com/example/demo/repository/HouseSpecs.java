package com.example.demo.repository;

import com.example.demo.model.House;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class HouseSpecs {

    public static Specification<House> nameLike(String name) {
        return (root, query, builder) ->
                name == null ?
                        builder.conjunction() :
                        builder.like(builder.lower(root.get("name")),
                                "%" + name.toLowerCase() + "%");
    }

    public static Specification<House> descriptionLike(String description) {
        return (root, query, builder) ->
                description == null ?
                        builder.conjunction() :
                        builder.like(builder.lower(root.get("description")),
                                "%" + description + "%");
    }

    public static Specification<House> areaBetween(Integer areaFrom, Integer areaTo) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (areaFrom != null) {
                predicateList.add(builder.ge(root.get("area"), areaFrom));
            }
            if (areaTo != null) {
                predicateList.add(builder.le(root.get("area"), areaTo));
            }
            return builder.and(predicateList.stream().toArray(Predicate[]::new));
        };
    }
}
