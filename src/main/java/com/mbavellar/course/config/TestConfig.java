package com.mbavellar.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mbavellar.course.entities.Category;
import com.mbavellar.course.entities.Order;
import com.mbavellar.course.entities.OrderItem;
import com.mbavellar.course.entities.Product;
import com.mbavellar.course.entities.User;
import com.mbavellar.course.entities.enums.OrderStatus;
import com.mbavellar.course.repositories.CategoryRepository;
import com.mbavellar.course.repositories.OrderItemRepository;
import com.mbavellar.course.repositories.OrderRepository;
import com.mbavellar.course.repositories.ProductRepository;
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
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private OrderItemRepository orderItemRepository;

  @Override
  public void run(String... args) throws Exception {
    
    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");
    
    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    
    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.50, "");
    Product p2 = new Product(null, "Smart TV", "HDR+ 4K 120Hz LED", 4999.00, "");
    Product p3 = new Product(null, "MacBook Pro", "500GB SSD, 15\" Retina Display", 14999.00, "");
    Product p4 = new Product(null, "Xbox series X", "1TB SSD 12 Teraglops", 3999.00, "");
    Product p5 = new Product(null, "Java for Dummies", "Java made easy!", 99.00, "");
    
    p1.getCategories().add(cat2);
    p2.getCategories().addAll(Arrays.asList(cat1, cat3));
    p3.getCategories().add(cat3);
    p4.getCategories().add(cat3);
    p5.getCategories().add(cat2);
    
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));    
    
    User user1 = new User(null, "Lara Croft", "croft@gmail.com", "(19) 99199-2602", "1234");
    User user2 = new User(null, "John Wick", "wick@gmail.com", "(19) 99199-2602", "1234");
    
    userRepository.saveAll(Arrays.asList(user1, user2));
    
    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, user1);
    Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, user2);
    Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
    
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    
    OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
    OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
    OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
    OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
    
    orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
  }
}
