package com.promineotech.birds.service;

import com.promineotech.birds.entity.Sightings;

public interface CreateSightingService {
  Sightings createSighting(String birdName, String city, String state, String username, String dateTime);
}
