package project.restaurant.models;

import jakarta.persistence.*;

@Entity
@Table
public class Order {
  
  private Integer orderNumber;
  private Integer status;
  private Integer waiterId;
  
  public Order(Integer orderNumber, Integer status, Integer waiterId) {
    this.orderNumber = orderNumber;
    this.status = status;
    this.waiterId = waiterId;
  }
  
  public Integer getOrderNumber() {
    return orderNumber;
  }
  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }
  
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }
  
  public Integer getWaiterId() {
    return waiterId;
  }
  public void setWaiterId(Integer waiterId) {
    this.waiterId = waiterId;
  }
  
  @Override
  public String toString() {
    return "order number:" + orderNumber.toString() + " status:" + status.toString() + " waiter id:" + waiterId.toString();
  }
}