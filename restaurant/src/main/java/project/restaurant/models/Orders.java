package project.restaurant.models;



import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Orders")
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderid;

  @Column(name="state", nullable = false)
  private String state;


  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "waiterid")
  private Waiters waiterid;
 
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "userid")
  private Users userid;

//  @OneToMany(cascade = CascadeType.ALL)
//  private Set<Itemsorders> itemsorders;

 
  
  public Orders(String state, Waiters waiterid, Users userid) {
    this.state = state;
    this.waiterid = waiterid;
    this.userid = userid;
  }
  
  public Orders() {
    
  }
  
  public Integer getOrderId() {
    return orderid;
  }
  public void setOrderId(Integer orderid) {
    this.orderid = orderid;
  }
  
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  
  public Waiters getWaiterId() {
    return waiterid;
  }
  public void setWaiterId(Waiters waiterid) {
    this.waiterid = waiterid;
  }
 

  public Users getUserid() {
	return userid;
  }

  public void setUserid(Users userid) {
	this.userid = userid;
  }

}


  
