package com.promineotech.birds.service;

import com.promineotech.birds.entity.Sightings;

public interface UpdateSightingService {
  Sightings updateSighting(int sightingId, int birdId, int locationId, int userId,
      String dateTime);
}
