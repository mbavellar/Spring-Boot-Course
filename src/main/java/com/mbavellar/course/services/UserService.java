package com.mbavellar.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.course.entities.User;
import com.mbavellar.course.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;
  
  public List<User> findAll() {
    return repository.findAll();
  }
  
  public User findById(Long id) {
    return repository.findById(id).get();
  }
  
  public User insert(User obj) {
    return repository.save(obj);
  }
  
  public void delete(Long id) {
    repository.deleteById(id);
  }
  
  public User update(Long id, User obj) {
    var entity = repository.getById(id);
    updatedata(entity, obj);
    return repository.save(entity);
  }

  private void updatedata(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}