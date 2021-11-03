package com.promineotech.birds.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sightings {
  private int sightingId;
  private int birdId;
  private int locationId;
  private int userId;
  private String dateTime;
}
