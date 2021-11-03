package com.promineotech.birds.service;

import com.promineotech.birds.entity.Locations;

public interface LocationService {
  Locations createLocation(String city, String state);
}
