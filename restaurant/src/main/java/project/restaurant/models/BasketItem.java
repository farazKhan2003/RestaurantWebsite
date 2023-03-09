package project.restaurant.models;

/**
 * This class represents an item from the menu in the customer's basket.
 */
public class BasketItem {
  private String name;
  private Integer quantity;
  private Float priceSum;

  /**
   * Constructs a BasketItem from the menu.
   *
   * @param name     the name of the item
   * @param quantity the number of this item the customer has added to the basket
   * @param priceSum the total value of this item according to the quantity (price * quantity)
   */
  public BasketItem(String name, Integer quantity, Float priceSum) {
    this.name = name;
    this.quantity = quantity;
    this.priceSum = priceSum;
  }

  /**
   * This method gets the name of item.
   *
   * @return the name of the item
   */
  public String getName() {
    return name;
  }

  /**
   * This method gets the quantity of the item.
   *
   * @return the quantity of the item
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * This method gets the the sum price of the item
   *
   * @return the total price according to the quantity
   */
  public float getPriceSum() {
    return priceSum;
  }
}
