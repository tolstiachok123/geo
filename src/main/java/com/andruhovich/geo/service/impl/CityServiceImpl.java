package com.andruhovich.geo.service.impl;

import com.andruhovich.geo.model.City;
import com.andruhovich.geo.repository.CityRepository;
import com.andruhovich.geo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl implements CityService {

  @Autowired
  private CityRepository cityRepository;

  @Override
  public void addCity(City city) {
    cityRepository.saveAndFlush(city);
  }

  @Override
  public void updateCity(City city) {
    City cityToUpdate = cityRepository.getByCityName(city.getCityName());
    cityToUpdate.setCityName(city.getCityName());
    cityToUpdate.setCityDescription(city.getCityDescription());
    cityRepository.save(cityToUpdate);
  }

  @Override
  public void deleteCity(String cityName){
    cityRepository.deleteByCityName(cityName);
  }

  @Override
  public City getCity(String cityName) {
    return cityRepository.getByCityName(cityName);
  }
}
