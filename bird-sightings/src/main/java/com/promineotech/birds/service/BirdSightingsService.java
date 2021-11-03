package com.promineotech.birds.service;

import java.util.List;
import com.promineotech.birds.entity.Sightings;

public interface BirdSightingsService {
  List<Sightings> fetchSightings(String birdName);
}
