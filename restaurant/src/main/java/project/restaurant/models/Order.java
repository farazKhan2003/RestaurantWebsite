package project.restaurant.models;

import jakarta.persistence.*;

@Entity
@Table
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderNumber;

  @Column(name="status", nullable = false)
  private Integer status;

  @Column(name="waiterId", nullable = false)
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
    return "Order number: " + orderNumber + ", Status: " + status + ", Waiter ID: " + waiterId;
  }
}