package com.promineotech.birds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.birds.dao.UpdateSightingDao;
import com.promineotech.birds.entity.Sightings;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicUpdateSightingService implements UpdateSightingService {

  @Autowired
  private UpdateSightingDao updateSightingDao;
  
  @Override
  public Sightings updateSighting(int sightingId, int birdId, int locationId, int userId,
      String dateTime) {
      return updateSightingDao.updateSighting(sightingId, birdId, locationId, userId, dateTime);
  }

}
