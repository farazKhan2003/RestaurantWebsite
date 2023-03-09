
package project.restaurant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Helps")
public class Helps {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer helpid;
  @Column(name = "state", nullable = false)
  private String state;
  @Column(name = "userid")
  private Integer userid;

  public Helps() {
  }

  public Integer getHelpid() {
    return helpid;
  }

  public void setHelpid(Integer helpid) {
    this.helpid = helpid;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public Helps(String state, Integer userid) {
    this.state = state;
    this.userid = userid;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
