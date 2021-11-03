package com.promineotech.birds.dao;

import com.promineotech.birds.entity.Locations;

public interface LocationDao {
  Locations createLocation(String city, String state);
}
