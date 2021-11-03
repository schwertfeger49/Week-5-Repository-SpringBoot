package com.promineotech.birds.dao;

import com.promineotech.birds.entity.Users;

public interface UserDao {
  Users createUser(String username);
}
