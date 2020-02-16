package com.example.demo.repository;

import com.example.demo.model.House;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class HouseRepositoryTest {
    @Autowired
    private HouseRepository houseRepository;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Test(expected = LazyInitializationException.class)
    public void testFindAll_LazyInitialized() {
        List<House> houses = houseRepository.findAll();
        assertThat(houses).hasSize(10);
        assertThat(houses.get(9).getImages()).hasSize(2);
    }

    @Test
    public void testFindAll_InTransaction() {
        List<House> houses = houseRepository.findAll();
        assertThat(houses).hasSize(10);
        assertThat(houses.get(9).getImages()).hasSize(2);
    }
}