package com.promineotech.birds.service;

import com.promineotech.birds.entity.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.birds.dao.LocationDao;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicLocationService implements LocationService {
  
  @Autowired
  private LocationDao locationDao;

  @Override
  public Locations createLocation(String city, String state) {
    return locationDao.createLocation(city, state);
  }

}
