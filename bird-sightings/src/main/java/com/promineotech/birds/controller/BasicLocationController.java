package com.promineotech.birds.controller;

import com.promineotech.birds.entity.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.birds.service.LocationService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicLocationController implements LocationController {
  
  @Autowired
  private LocationService locationService;

  @Override
  public Locations createdLocation(String city, String state) {
    return locationService.createLocation(city, state);
  }

}
