package project.restaurant.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "MenuItems")
public class MenuItems {
  //Empty Constructor
  public MenuItems() {}
  
  //Constructor taking all parameters
  public MenuItems(String itemName, String description, Float price, byte[] img, Integer stockAmount, Integer waiterID) {
    this.itemName = itemName;
    this.description = description;
    this.price = price;
    this.img = img;
    this.stockAmount = stockAmount;
    this.waiterID = waiterID;
  }
  
  public MenuItems(String itemName, String description, Float price, Integer stockAmount, Integer waiterID) {
    this.itemName = itemName;
    this.description = description;
    this.price = price;
    this.stockAmount = stockAmount;
    this.waiterID = waiterID;
  }
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer itemID;
  
  @Column(name = "itemName", nullable = false, unique = true)
  private String itemName;
  
  @Column(name = "description", nullable = false)
  private String description;
  
  @Column(name = "price", nullable = false)
  private Float price;
  
  @Column(name = "stockAmount", nullable = true)
  private Integer stockAmount;
  
  @Column(name = "waiterID", nullable = false)
  private Integer waiterID;
  
  @Column(name = "img", nullable = true)
  private byte[] img;
  
  public Integer getItemID() {
    return itemID;
  }

  public void setItemID(Integer itemID) {
    this.itemID = itemID;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public byte[] getImg() {
    return img;
  }

  public void setImg(byte[] img) {
    this.img = img;
  }

  public Integer stockAmount() {
    return stockAmount;
  }

  public void stockAmount(Integer stockAmount) {
    this.stockAmount = stockAmount;
  }

  public Integer getWaiterID() {
    return waiterID;
  }

  public void setWaiterID(Integer waiterID) {
    this.waiterID = waiterID;
  }
}