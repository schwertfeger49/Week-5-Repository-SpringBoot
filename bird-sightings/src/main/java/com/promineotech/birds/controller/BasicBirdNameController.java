package com.promineotech.birds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.birds.entity.BirdNames;
import com.promineotech.birds.entity.BirdTypeEnum;
import com.promineotech.birds.service.BirdNameService;
import com.promineotech.birds.service.LocationService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicBirdNameController implements BirdNameController {

  @Autowired
  private BirdNameService birdNameService;
  
  @Override
  public BirdNames createdBirdName(BirdTypeEnum typeName, String birdName) {
    return birdNameService.createBirdName(typeName, birdName);
  }

}
