package com.mbavellar.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbavellar.course.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
  
  @GetMapping
  public ResponseEntity<User> findAll() {
    User user =
        new User(1L, "John Wick", "wick@gmail.com", "(19) 99199-2602", "1234");
    return ResponseEntity.ok().body(user);
  }
}
