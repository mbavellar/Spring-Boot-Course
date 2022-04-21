package com.mbavellar.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mbavellar.course.entities.Category;
import com.mbavellar.course.entities.Order;
import com.mbavellar.course.entities.User;
import com.mbavellar.course.entities.enums.OrderStatus;
import com.mbavellar.course.repositories.CategoryRepository;
import com.mbavellar.course.repositories.OrderRepository;
import com.mbavellar.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
  
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public void run(String... args) throws Exception {
    
    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");
    
    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    
    User user1 = new User(null, "Lara Croft", "croft@gmail.com", "(19) 99199-2602", "1234");
    User user2 = new User(null, "John Wick", "wick@gmail.com", "(19) 99199-2602", "1234");
    
    userRepository.saveAll(Arrays.asList(user1, user2));
    
    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, user1);
    Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, user2);
    Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
    
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }
}
