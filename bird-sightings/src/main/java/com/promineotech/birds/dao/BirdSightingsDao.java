package com.promineotech.birds.dao;

import java.util.List;
import com.promineotech.birds.entity.Sightings;

public interface BirdSightingsDao {
  List<Sightings> fetchSightings(String birdName);
}
