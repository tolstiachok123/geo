package com.andruhovich.geo.service;

import com.andruhovich.geo.model.City;

public interface CityService {

  void addCity(City city);

  void updateCity(String newCityName, City city);

  void deleteCity(String cityName);

  City getCity(String cityName);

}
