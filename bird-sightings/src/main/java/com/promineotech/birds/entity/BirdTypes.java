package com.promineotech.birds.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BirdTypes {
  private int typeId;
  private String typeName;
  private String typeDescription;
}
