package com.promineotech.birds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.birds.entity.Sightings;
import com.promineotech.birds.service.CreateSightingService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicCreateSightingController implements CreateSightingController {

  @Autowired
  private CreateSightingService createSightingService;
  
  @Override
  public Sightings createdSighting(String birdName, String city, String state, String username,
      String dateTime) {
    return createSightingService.createSighting(birdName, city, state, username, dateTime);
  }

}
