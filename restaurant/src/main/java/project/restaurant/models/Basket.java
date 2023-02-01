package project.restaurant.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MenuItems> items = new ArrayList<>();

    private Float totalPrice;

    public Basket() {}

    public Basket(List<MenuItems> items, Float totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
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
}
