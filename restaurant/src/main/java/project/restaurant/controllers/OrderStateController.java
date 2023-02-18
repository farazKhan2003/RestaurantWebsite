package project.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.restaurant.models.ItemsOrders;
import project.restaurant.models.Orders;
import project.restaurant.repository.ItemsordersRepository;
import project.restaurant.repository.MenuItemsRepository;
import project.restaurant.repository.OrdersRepository;
import project.restaurant.repository.UsersRepository;
import project.restaurant.repository.WaitersRepository;

@Controller
public class OrderStateController {

  @Autowired
  private OrdersRepository oRepo;
    
  @GetMapping("/orders")
  public String getOrders(Model model) {
    
    List<Orders> waiterOrder = oRepo.findOrderByWaiterId(77);
    List<Orders> deliveryStateOrder = new ArrayList<Orders>();
    List<Orders> otherStateOrder = new ArrayList<Orders>();
    
    for(int i = 0; i<waiterOrder.size();i++) {
      Orders order = waiterOrder.get(i);
      if(order.getState().equals("ready")){
        deliveryStateOrder.add(order);
      }else {
        otherStateOrder.add(order);
      }
    }
    
    System.out.println(deliveryStateOrder.size());
    System.out.println(otherStateOrder.size());
    
    model.addAttribute("deliveryStateOrder", deliveryStateOrder);
    model.addAttribute("otherStateOrder", otherStateOrder);
    
    return "orders";
  }
}