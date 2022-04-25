package com.mbavellar.course.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mbavellar.course.entities.User;
import com.mbavellar.course.repositories.UserRepository;
import com.mbavellar.course.resources.exceptions.DatabaseException;
import com.mbavellar.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;
  
  public List<User> findAll() {
    return repository.findAll();
  }
  
  public User findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
  }
  
  public User insert(User obj) {
    return repository.save(obj);
  }
  
  public void delete(Long id) {

    try {
      repository.deleteById(id);
//      repository.findById(id).map(entity -> {repository.deleteById(id);
//                                return ResponseEntity.ok().build();
//                                }).orElse(ResponseEntity.notFound().build());
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
  }
  
  public User update(Long id, User obj) {
    
    try {
      var entity = repository.getById(id);
      updatedata(entity, obj);
      return repository.save(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  private void updatedata(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}