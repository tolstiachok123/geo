package com.andruhovich.geo.repository;

import com.andruhovich.geo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

  City getByCityName(String cityName);

  void deleteByCityName(String cityName);

}
