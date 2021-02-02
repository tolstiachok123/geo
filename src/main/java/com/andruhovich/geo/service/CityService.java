package com.andruhovich.geo.service;

import com.andruhovich.geo.model.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface CityService {

  void addCity(City city);

  void updateCity(City city);

  void deleteCity(String cityName);

  City getCity(String cityName);

}
