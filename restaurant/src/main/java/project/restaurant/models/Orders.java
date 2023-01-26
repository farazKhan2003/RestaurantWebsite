package project.restaurant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
  public Orders() {}
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderid;


  public Integer getOrderid() {
    return orderid;
  }


  public void setOrderid(Integer orderid) {
    this.orderid = orderid;
  }
  
  
  
  
}
