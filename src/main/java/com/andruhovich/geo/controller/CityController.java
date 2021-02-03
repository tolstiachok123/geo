package com.andruhovich.geo.controller;

import com.andruhovich.geo.model.City;
import com.andruhovich.geo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("city")
public class CityController {

  @Autowired
  private CityService cityService;

  @PutMapping
  public void addCity(@RequestBody City city) {
    cityService.addCity(city);
  }

  @PostMapping
  public void updateCityDescription(@RequestBody City city) {
    cityService.updateCityDescription(city);
  }

  @DeleteMapping(value = "/{cityName}")
  public void deleteCity(@PathVariable(name = "cityName") String cityName) {
    cityService.deleteCity(cityName);
  }
}
