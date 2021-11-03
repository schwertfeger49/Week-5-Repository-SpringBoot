package com.promineotech.birds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.birds.entity.Sightings;
import com.promineotech.birds.service.BirdNameService;
import com.promineotech.birds.service.DeleteSightingService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicDeleteSightingController implements DeleteSightingController {

  @Autowired
  private DeleteSightingService deleteSightingService;
  
  @Override
  public void deleteSightings(int sightingId) {
    deleteSightingService.deleteSighting(sightingId);
  }

}
