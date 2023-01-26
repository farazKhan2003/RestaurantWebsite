package project.restaurant.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;

    @Column(name="state", nullable = false)
    private Integer state;

    @Column(name="waiterId", nullable = false)
    private Integer waiterId;

    public Orders(Integer orderNumber, Integer state, Integer waiterId) {
        this.orderNumber = orderNumber;
        this.state = state;
        this.waiterId = waiterId;
    }

    public Orders() {

    }

    public Integer getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getStatus() {
        return state;
    }
    public void setStatus(Integer state) {
        this.state = state;
    }

    public Integer getWaiterId() {
        return waiterId;
    }
    public void setWaiterId(Integer waiterId) {
        this.waiterId = waiterId;
    }

    @Override
    public String toString() {
        return "Order number: " + orderNumber + ", State: " + state + ", Waiter ID: " + waiterId;
    }
}
