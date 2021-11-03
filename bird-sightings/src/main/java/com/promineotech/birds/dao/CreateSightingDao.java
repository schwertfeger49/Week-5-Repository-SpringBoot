package com.promineotech.birds.dao;

import com.promineotech.birds.entity.Sightings;

public interface CreateSightingDao {
  Sightings createSighting(String birdName, String city, String state, String username, String dateTime);
}
