package com.example.demo.repository;

import com.example.demo.model.House;
import org.springframework.data.jpa.domain.Specification;

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
}
