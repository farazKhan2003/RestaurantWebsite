package project.restaurant.models;

public class BasketItemWithId extends BasketItem {
    private Integer id;

    public BasketItemWithId(String name, Integer quantity, Float priceSum, Integer id) {
        super(name, quantity, priceSum);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
