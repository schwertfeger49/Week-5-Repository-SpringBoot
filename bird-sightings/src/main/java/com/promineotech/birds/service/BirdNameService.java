package com.promineotech.birds.service;

import com.promineotech.birds.entity.BirdNames;
import com.promineotech.birds.entity.BirdTypeEnum;

public interface BirdNameService {
  BirdNames createBirdName(BirdTypeEnum typeName, String birdName);
}
