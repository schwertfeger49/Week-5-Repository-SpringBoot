package com.promineotech.birds.dao;

import com.promineotech.birds.entity.Sightings;

public interface UpdateSightingDao {
  Sightings updateSighting(int sightingId, int birdId, int locationId, int userId,
      String dateTime);
}
