package project.restaurant.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<MenuItems> items;
    private Float totalPrice;
    private final Integer tableNumber;

    public Basket(Integer tableNumber) {
        this.items = new ArrayList<>();
        this.totalPrice = (float) 0;
        this.tableNumber = tableNumber;
    }

    public List<MenuItems> getItems() {
        return items;
    }

    public void setItems(List<MenuItems> items) {
        this.items = items;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
