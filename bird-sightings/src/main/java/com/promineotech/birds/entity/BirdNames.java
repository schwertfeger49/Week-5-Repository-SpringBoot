package com.promineotech.birds.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BirdNames {
  private int birdId;
  private BirdTypeEnum typeName;
  private String birdName;
}
