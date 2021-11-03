package com.promineotech.birds.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.birds.dao.UserDao;
import com.promineotech.birds.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicUserService implements UserService {

  @Autowired
  private UserDao userDao;
  
  @Override
  public Users createUser(String username) {
    return userDao.createUser(username);
  }

}
