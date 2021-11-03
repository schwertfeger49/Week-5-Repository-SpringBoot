package com.promineotech.birds.dao;

import com.promineotech.birds.entity.BirdNames;
import com.promineotech.birds.entity.BirdTypeEnum;

public interface BirdNameDao {
  BirdNames createBirdName(BirdTypeEnum typeName, String birdName);
}
