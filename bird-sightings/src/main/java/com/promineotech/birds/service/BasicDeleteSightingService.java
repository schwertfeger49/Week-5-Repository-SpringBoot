package com.promineotech.birds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.birds.dao.BirdNameDao;
import com.promineotech.birds.dao.DeleteSightingDao;
import com.promineotech.birds.entity.Sightings;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicDeleteSightingService implements DeleteSightingService {

  @Autowired
  private DeleteSightingDao deleteSightingDao;
  
  @Override
  public void deleteSighting(int sightingId) {
    deleteSightingDao.deleteSighting(sightingId);
  }

}
