package project.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import project.restaurant.models.Orders;
import project.restaurant.models.Waiters;
import project.restaurant.repository.OrdersRepository;

/**
 * This is class is used to react to the button of orders web page and generate list for it.
 */
@Controller
public class OrderStateController {

  @Autowired
  private OrdersRepository oRepo;
  
  /**
   * This function will offer the data the need to generate ready state list and other state list for orders web page.
   *
   * @param model is the Model type parameter help the back-end code to add attribute for front-end web page
   */
  @GetMapping("/waiterOrder")
  public String getOrders(Model model,HttpSession session) {
    Waiters waiter = (Waiters) session.getAttribute("waiter");
    List<Orders> allOrders = oRepo.findByState();
    List<Orders> waiterOrder = oRepo.findOrderByWaiterId(waiter.getWaiterid());
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
    model.addAttribute("allorders",allOrders);
    model.addAttribute("deliveryStateOrder", deliveryStateOrder);
    model.addAttribute("otherStateOrder", otherStateOrder);
    
    return "orders";
  }
  
  /**
   * This function will react to the delivered button of ready state order list to set the order state to delivered.
   * 
   * @param input is the id of order that waiter want to set its state to delivered.
   * @param model is the Model type parameter help the back-end code to add attribute for front-end web page
   */
  @PostMapping("/changeToDelivered")
  public String changeStateToDelivered(@Param("input") Integer input,Model model,HttpSession session) {
    Orders order = oRepo.findOrderByOrderId(input);
    order.setState("delivered");
    oRepo.save(order);
    getOrders(model,session);
    return "orders";
  }
  
  @PostMapping("/changeToConfirmed")
  public String changeStateToConfirmed(@Param("input") Integer input,Model model,HttpSession session) {
    Orders order = oRepo.findOrderByOrderId(input);
    order.setState("confirmed");
    Waiters waiter = (Waiters)session.getAttribute("waiter");
    order.setWaiterId(waiter);
    oRepo.save(order);
    getOrders(model,session);
    return "orders";
  }
}
