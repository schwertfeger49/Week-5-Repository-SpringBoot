package com.promineotech.birds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.birds.dao.BirdNameDao;
import com.promineotech.birds.entity.BirdNames;
import com.promineotech.birds.entity.BirdTypeEnum;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicBirdNameService implements BirdNameService {

  @Autowired
  private BirdNameDao birdNameDao;
  
  @Override
  public BirdNames createBirdName(BirdTypeEnum typeName, String birdName) {
    return birdNameDao.createBirdName(typeName, birdName);
  }

}
