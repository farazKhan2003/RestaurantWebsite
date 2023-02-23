package project.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.restaurant.models.Orders;
import project.restaurant.repository.OrdersRepository;

@Controller
public class OrderStateController {

  @Autowired
  private OrdersRepository oRepo;
  
  /**
   * This function will offer the data the need to generate ready state list and other state list for orders web page.
   *
   * @param model is the Model type parameter help the back-end code to add attribute for front-end web page
   */
  @GetMapping("/orders")
  public String getOrders(Model model) {
    
    List<Orders> waiterOrder = oRepo.findOrderByWaiterId(77);
    List<Orders> deliveryStateOrder = new ArrayList<Orders>();
    List<Orders> otherStateOrder = new ArrayList<Orders>();
    
    for(int i = 0; i<waiterOrder.size();i++) {
      Orders order = waiterOrder.get(i);
      if(order.getState().equals("ready")){
        deliveryStateOrder.add(order);
      } else {
        otherStateOrder.add(order);
      }
    }
    
    System.out.println(deliveryStateOrder.size());
    System.out.println(otherStateOrder.size());
    
    model.addAttribute("deliveryStateOrder", deliveryStateOrder);
    model.addAttribute("otherStateOrder", otherStateOrder);
    
    return "orders";
  }
  
  @PostMapping("/changeToDelivered")
  public String changeStateToDelivered(@Param("input") Integer input,Model model) {
    Orders order = oRepo.findOrderByOrderId(input);
    order.setState("delivered");
    oRepo.save(order);
    getOrders(model);
    return "orders";
  }
}