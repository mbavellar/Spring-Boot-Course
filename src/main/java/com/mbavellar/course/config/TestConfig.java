package com.mbavellar.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mbavellar.course.entities.User;
import com.mbavellar.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
  
  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    
    User user1 = new User(null, "Lara Croft", "croft@gmail.com", "(19) 99199-2602", "1234");
    User user2 = new User(null, "John Wick", "wick@gmail.com", "(19) 99199-2602", "1234");
    
    userRepository.saveAll(Arrays.asList(user1, user2));
  }
}
