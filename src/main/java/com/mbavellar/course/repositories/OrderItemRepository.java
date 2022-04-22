package com.mbavellar.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbavellar.course.entities.OrderItem;
import com.mbavellar.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}