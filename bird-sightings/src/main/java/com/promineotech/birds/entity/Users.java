package com.promineotech.birds.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Users {
  private int userId;
  private String username;
}
