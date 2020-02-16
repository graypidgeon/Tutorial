package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class HouseSpecs {

    public static Specification<House> fetchMainImage() {
        return (root, query, builder) -> {
            Fetch<House, Image> fetch = root.fetch("images", JoinType.LEFT);
            Join<House, Image> join = (Join<House, Image>) fetch;
            query.distinct(true);
            return builder.equal(join.get("imageSection"), ImageSection.MAIN);
        };
    }

    public static Specification<House> nameLike(String name) {
        return (root, query, builder) ->
                name == null ?
                        builder.conjunction() :
                        builder.like(builder.lower(root.get("name")),
                                "%" + name.toLowerCase() + "%");
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

    public static Specification<House> garageEquals(Garage garage) {
        return (root, query, builder) ->
                garage == null ?
                        builder.conjunction() :
                        builder.equal(root.get("garage"), garage);
    }
}
