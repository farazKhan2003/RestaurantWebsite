package project.restaurant.models;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Users")
public class Users {

  public Users() {
  }

  public Users(String usertype, String username, String passwords, String email_address) {
    this.usertype = usertype;
    this.username = username;
    this.passwords = passwords;
    this.email_address = email_address;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userid;

  @Column(name = "usertype", nullable = false)
  private String usertype;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "passwords", nullable = false, length = 64)
  private String passwords;

  @Column(name = "email_address", nullable = false)
  private String email_address;

  @OneToMany(cascade = CascadeType.MERGE)
  private Set<Orders> orders;

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getUsertype() {
    return usertype;
  }

  public void setUsertype(String usertype) {
    this.usertype = usertype;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswords() {
    return passwords;
  }

  public void setPasswords(String passwords) {
    this.passwords = passwords;
  }
}
