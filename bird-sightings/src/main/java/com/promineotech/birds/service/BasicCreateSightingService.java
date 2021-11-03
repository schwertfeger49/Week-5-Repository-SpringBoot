package com.promineotech.birds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.birds.dao.BirdNameDao;
import com.promineotech.birds.dao.CreateSightingDao;
import com.promineotech.birds.entity.Sightings;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicCreateSightingService implements CreateSightingService {

  @Autowired
  private CreateSightingDao createSightingDao;
  
  @Override
  public Sightings createSighting(String birdName, String city, String state, String username,
      String dateTime) {
      return createSightingDao.createSighting(birdName, city, state, username, dateTime);
  }

}
