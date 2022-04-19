package com.mbavellar.course.entities.enums;

public enum OrderStatus {

  WAITING_PAYMENT(1),
  PAID(2),
  SHIPPED(3),
  DELIVERED(4),
  CANCELED(5);
  
  private int orderCode;
  private OrderStatus(int orderCode) {
    this.orderCode = orderCode;
  }
  
  public int getOrderCode() {
    return orderCode;
  }
  
  public static OrderStatus valueOf(int orderCode) {
    for (var orderStatus : OrderStatus.values())
      if (orderStatus.getOrderCode() == orderCode)
        return orderStatus;
    throw new IllegalArgumentException("Invalid Order Status Code!");
  }
}
