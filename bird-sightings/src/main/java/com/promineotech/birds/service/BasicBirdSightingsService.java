package com.promineotech.birds.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.birds.dao.BirdSightingsDao;
import com.promineotech.birds.entity.Sightings;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicBirdSightingsService implements BirdSightingsService {

  @Autowired
  private BirdSightingsDao birdSightingsDao;
  
  @Override
  public List<Sightings> fetchSightings(String birdName) {
    return birdSightingsDao.fetchSightings(birdName);
  }

}
