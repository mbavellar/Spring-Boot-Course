package com.mbavellar.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.course.entities.Product;
import com.mbavellar.course.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;
  
  public List<Product> findAll() {
    var list = repository.findAll();
    return list;
  }
  
  public Product findById(Long id) {
    var obj = repository.findById(id);
    return obj.get();
  }
}