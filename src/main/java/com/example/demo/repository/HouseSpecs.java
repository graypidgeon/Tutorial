package com.example.demo.repository;

import com.example.demo.model.House;
import com.example.demo.model.Storey;
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

    public static Specification<House> usageAreaBetween(Integer areaFrom, Integer areaTo) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (areaFrom != null) {
                predicateList.add(builder.ge(root.get("usageArea"), areaFrom));
            }
            if (areaTo != null) {
                predicateList.add(builder.le(root.get("usageArea"), areaTo));
            }
            return builder.and(predicateList.stream().toArray(Predicate[]::new));
        };
    }

    public static Specification<House> minWidthAndHeight(Integer minWidth, Integer minHeight) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (minWidth != null) {
                predicateList.add(builder.ge(root.get("width"), minWidth));
            }
            if (minHeight != null) {
                predicateList.add(builder.ge(root.get("height"), minHeight));
            }
            return builder.and(predicateList.stream().toArray(Predicate[]::new));
        };
    }

    public static Specification<House> buildingAreaBetween(Integer buildingAreaFrom, Integer buildingAreaTo) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (buildingAreaFrom != null) {
                predicateList.add(builder.ge(root.get("buildingArea"), buildingAreaFrom));
            }
            if (buildingAreaTo != null) {
                predicateList.add(builder.le(root.get("buildingArea"), buildingAreaTo));
            }
            return builder.and(predicateList.stream().toArray(Predicate[]::new));
        };
    }

    public static Specification<House> storeyEquals(Storey storey) {
        return (root, query, builder) ->
                storey == null ?
                        builder.conjunction() :
                        builder.equal(root.get("storey"), storey);
    }
}
