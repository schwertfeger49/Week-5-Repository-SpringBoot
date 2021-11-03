package com.promineotech.birds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.birds.entity.Sightings;
import com.promineotech.birds.service.UpdateSightingService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicUpdateSightingController implements UpdateSightingController {

  @Autowired
  private UpdateSightingService updateSightingService;
  
  @Override
  public Sightings updateSighting(int sightingId, int birdId, int locationId, int userId,
      String dateTime) {
    return updateSightingService.updateSighting(sightingId, birdId, locationId, userId, dateTime);
  }

}
