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
@Table(name = "MenuItems")
public class MenuItems {
  //Empty Constructor
  public MenuItems() {}
  
  //Constructor taking all parameters
  public MenuItems(String itemName, String descriptions, Float price, String img, Integer stockAmount, Waiters waiterid, String category, String ingredients, Integer calories) {
    this.descriptions = descriptions;
    this.img = img;
    this.itemName = itemName;
    this.price = price;
    this.stockAmount = stockAmount;
    this.category = category;
    this.waiterid = waiterid;
    this.ingredients =ingredients;
    this.calories = calories;
  }
  
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer itemid;
  
  @Column(name = "descriptions", nullable = false)
  private String descriptions;
  
  @Column(name = "img", nullable = true)
  private String img;
  
  @Column(name = "itemName", nullable = false, unique = true)
  private String itemName;
  
  @Column(name = "price", nullable = false)
  private Float price;
  
  @Column(name = "stockAmount", nullable = true)
  private Integer stockAmount;

  @Column(name = "category", nullable = false)
  private String category;
  
  @Column(name = "ingredients", nullable = false)
  private String ingredients;
  
  @Column(name = "calories", nullable = false)
  private Integer calories;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "waiterid")
  private Waiters waiterid;
  
  @OneToMany(cascade = CascadeType.ALL)
  private Set<ItemsOrders> itemsorders;
 
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(String descriptions) {
    this.descriptions = descriptions;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public Waiters getWaiterid() {
    return waiterid;
  }

  public void setWaiterid(Waiters waiterid) {
    this.waiterid = waiterid;
  }

  public Integer getItemid() {
	return itemid;
  }
	
  public void setItemid(Integer itemid) {
	this.itemid = itemid;
  }
	
  public Integer getStockAmount() {
	return stockAmount;
  }
	
  public void setStockAmount(Integer stockAmount) {
	this.stockAmount = stockAmount;
  }
	
  public String getCategory() {
	return category;
  }
	
  public void setCategory(String category) {
	this.category = category;
  }
	
  public String getIngredients() {
	return ingredients;
  }
	
  public void setIngredients(String ingredients) {
	this.ingredients = ingredients;
  }
	
  public Integer getCalories() {
	return calories;
  }
	
  public void setCalories(Integer calories) {
	this.calories = calories;
  }
	  
}
