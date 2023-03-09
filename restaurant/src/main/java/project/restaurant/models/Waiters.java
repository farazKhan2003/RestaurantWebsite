package project.restaurant.models;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Waiters")
public class Waiters {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer waiterid;

  @Column(name = "permissions", nullable = false)
  private Integer permissions;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "userid")
  private Users userid;

  @OneToMany(cascade = CascadeType.ALL)
  private Set<MenuItems> menuItems;

  @OneToMany(cascade = CascadeType.ALL)
  private Set<Orders> orders;

  public Waiters() {
  }

  public Waiters(Integer permissions, Users userid) {
    this.userid = userid;
    this.permissions = permissions;
  }

  public Integer getWaiterid() {
    return waiterid;
  }

  public void setWaiterid(Integer waiterid) {
    this.waiterid = waiterid;
  }

  public Integer getPermissions() {
    return permissions;
  }

  public void setPermissions(Integer permissions) {
    this.permissions = permissions;
  }

  public Users getUserid() {
    return userid;
  }

  public void setUserid(Users userid) {
    this.userid = userid;
  }
}
