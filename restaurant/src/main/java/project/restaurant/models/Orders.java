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
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderId;
  
  @Column(name = "confirmed", nullable = false)
  private Boolean confirmed;
  
  public Orders() {}
  
  public Orders(Boolean confirmed) {
    this.confirmed = confirmed;
  }
  
  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Boolean getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(Boolean confirmed) {
    this.confirmed = confirmed;
  }

}
