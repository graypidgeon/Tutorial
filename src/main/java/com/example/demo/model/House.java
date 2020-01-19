package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "house_seq", allocationSize=1)
    private long id;
    private String name;
    private String description;
    private String imagePath;
    private int usageArea;
    private int width;
    private int height;

    public void updateFromForm(House house) {
        this.setName(house.getName());
        this.setDescription(house.getDescription());
        this.setUsageArea(house.getUsageArea());
        this.setWidth(house.getWidth());
        this.setHeight(house.getHeight());
    }
}
