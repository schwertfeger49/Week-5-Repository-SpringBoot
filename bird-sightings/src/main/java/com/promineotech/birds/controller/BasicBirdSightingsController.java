package com.promineotech.birds.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.birds.entity.Sightings;
import com.promineotech.birds.service.BirdSightingsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicBirdSightingsController implements BirdSightingsController {

  @Autowired
  private BirdSightingsService birdSightingsService;
  
  @Override
  public List<Sightings> fetchSightings(String birdName) {
    return birdSightingsService.fetchSightings(birdName);
  }

}
