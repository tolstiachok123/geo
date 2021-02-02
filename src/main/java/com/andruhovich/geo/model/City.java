package com.andruhovich.geo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column
  private String cityName;

  @Column
  private String cityDescription;

  public long getId() {
    return id;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCityDescription() {
    return cityDescription;
  }

  public void setCityDescription(String cityDescription) {
    this.cityDescription = cityDescription;
  }

  @Override
  public String toString() {
    return "City{" +
        "id=" + id +
        ", cityName='" + cityName + '\'' +
        ", cityDescription='" + cityDescription + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof City)) return false;
    City city = (City) o;
    return getId() == city.getId() &&
        Objects.equals(getCityName(), city.getCityName()) &&
        Objects.equals(getCityDescription(), city.getCityDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getCityName(), getCityDescription());
  }
}
