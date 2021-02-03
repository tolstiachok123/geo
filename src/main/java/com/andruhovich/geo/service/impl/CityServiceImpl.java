package com.andruhovich.geo.service.impl;

import com.andruhovich.geo.model.City;
import com.andruhovich.geo.repository.CityRepository;
import com.andruhovich.geo.service.CityService;
import com.sun.xml.internal.ws.util.StringUtils;
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
    city.setCityName(nameCorrect(city.getCityName()));
    cityRepository.saveAndFlush(city);
  }

  @Override
  public void updateCity(String newCityName, City city) {
    newCityName = nameCorrect(newCityName);
    city.setCityName(nameCorrect(city.getCityName()));
    City cityToUpdate = cityRepository.getByCityName(city.getCityName());
    if (newCityName != null && !newCityName.equals(city.getCityName())) {
      cityToUpdate.setCityName(newCityName);
      cityToUpdate.setCityDescription(city.getCityDescription());
      deleteCity(city.getCityName());
    } else {
      cityToUpdate.setCityDescription(city.getCityDescription());
    }
    cityRepository.saveAndFlush(cityToUpdate);
  }

  @Override
  public void deleteCity(String cityName){
    cityRepository.deleteByCityName(cityName);
  }

  @Override
  public City getCity(String cityName) {
    return cityRepository.getByCityName(cityName);
  }

  private String nameCorrect(String cityName) {
    return StringUtils.capitalize(cityName.toLowerCase());
  }
}
