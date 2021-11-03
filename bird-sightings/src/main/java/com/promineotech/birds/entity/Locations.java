package com.promineotech.birds.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Locations {
  private int locationId;
  private String city;
  private String state;
}
