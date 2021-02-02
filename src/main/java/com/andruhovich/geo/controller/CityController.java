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
  public void updateCity(@RequestBody City city) {
    cityService.updateCity(city);
  }
}
