package com.example.demo.model;

import com.example.demo.utils.CollectionUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "house_seq", allocationSize=1)
    private long id;
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "house_id")
    private Set<Image> images;
    private int usageArea;
    private int buildingArea;
    private int garageArea;
    private int boilerRoomArea;
    private int width;
    private int height;
    @Enumerated(EnumType.STRING)
    private Storey storey;
    @Enumerated(EnumType.STRING)
    private Garage garage;

    public void updateFromForm(House house) {
        this.setName(house.getName());
        this.setDescription(house.getDescription());
        this.setUsageArea(house.getUsageArea());
        this.setGarageArea(house.getGarageArea());
        this.setBoilerRoomArea(house.getBoilerRoomArea());
        this.setBuildingArea(house.getBuildingArea());
        this.setWidth(house.getWidth());
        this.setHeight(house.getHeight());
        this.setStorey(house.getStorey());
        this.setGarage(house.getGarage());
    }

    public Image getMainImage() {
        if (images != null) {
            return images.stream()
                    .filter(image -> image.getImageSection().equals(ImageSection.MAIN))
                    .collect(CollectionUtils.toSingleton());
        }
        return null;
    }

    public List<Image> getImagesBySection(ImageSection section) {
        if (images != null) {
            return images.stream()
                    .filter(image -> image.getImageSection().equals(section))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
