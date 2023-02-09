package project.restaurant.models;

public class BasketItem {
    private String name;
    private Integer quantity;
    private Float priceSum;

    public BasketItem(String name, Integer quantity, Float priceSum) {
        this.name = name;
        this.quantity = quantity;
        this.priceSum = priceSum;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPriceSum() {
        return priceSum;
    }
}
