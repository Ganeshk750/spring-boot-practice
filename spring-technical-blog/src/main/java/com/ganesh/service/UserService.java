package com.ganesh.service;

import com.ganesh.model.User;

public interface UserService {

  public User login(User user);
  public void registerUser(User newUser);
}
