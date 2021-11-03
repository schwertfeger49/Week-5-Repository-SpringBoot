package com.promineotech.birds.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.birds.entity.Users;
import com.promineotech.birds.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicUserController implements UserController {
  
  @Autowired
  private UserService userService;

  @Override
  public Users createdUser(String username) {
    return userService.createUser(username);
  }

}
