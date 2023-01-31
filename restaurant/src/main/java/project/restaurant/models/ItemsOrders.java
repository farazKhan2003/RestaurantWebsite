package project.restaurant.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Itemsorders")
public class ItemsOrders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemordersid;
      
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemid")
    private MenuItems itemid;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderid")
    private Orders orderid;
    
    public ItemsOrders() {}
    
    public ItemsOrders(MenuItems itemid, Orders orderid) {
        this.itemid = itemid;
        this.orderid = orderid;
    }

    public Integer getItemordersid() {
        return itemordersid;
    }

    public void setItemordersid(Integer itemordersid) {
        this.itemordersid = itemordersid;
    }

    public MenuItems getItemid() {
        return itemid;
    }

    public void setItemid(MenuItems itemid) {
        this.itemid = itemid;
    }

    public Orders getOrderid() {
        return orderid;
    }

    public void setOrderid(Orders orderid) {
        this.orderid = orderid;
    }
}
    
    