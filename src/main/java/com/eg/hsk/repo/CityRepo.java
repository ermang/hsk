package com.eg.hsk.repo;

import com.eg.hsk.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepo extends JpaRepository<City, Long> {
    List<City> findAllByOrderByNameAsc();
}
