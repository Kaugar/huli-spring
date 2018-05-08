package com.greenfox.hulispring.repositories;

import com.greenfox.hulispring.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository <Message,Long> {

  List<Message> findAll();

}
