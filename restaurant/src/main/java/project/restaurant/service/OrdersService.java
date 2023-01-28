package project.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.restaurant.repository.OrdersRepostitory;

@Service
public class OrdersService {
  
  private OrdersRepostitory Orders;
  
  @Autowired
  public OrdersService(OrdersRepostitory Orders) {
    this.Orders = Orders;
  }

}
