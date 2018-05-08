package com.greenfox.hulispring.controllers;

import com.greenfox.hulispring.models.Data;
import com.greenfox.hulispring.models.Message;
import com.greenfox.hulispring.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
  @Autowired
  MessageRepo messageRepo;

  @GetMapping (value = "/hello")
  public Data hello() {
    return new Data(messageRepo.findAll(), "ok");
  }
}
