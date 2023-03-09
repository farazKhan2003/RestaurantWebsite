package project.restaurant.models;

/**
 * {@inheritDoc}
 *
 * <p>This class also has the id of the item.</p>
 */
public class BasketItemWithId extends BasketItem {
  private Integer id;

  /**
   * {@inheritDoc}
   *
   * @param id the id of item in the database
   */
  public BasketItemWithId(String name, Integer quantity, Float priceSum, Integer id) {
    super(name, quantity, priceSum);
    this.id = id;
  }

  /**
   * This method gets the id of the item.
   *
   * @return the id of the item
   */
  public Integer getId() {
    return id;
  }
}
