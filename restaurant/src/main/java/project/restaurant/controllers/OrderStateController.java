package project.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.restaurant.models.ItemsOrders;

@Controller
public class OrderStateController {

    @GetMapping("/orders")
    public String getOrders() {
        return "orders";
    }
    
    @PostMapping("/getDeliveryStateOrder")
    public String placeDeliveryOrder(Model model) {
      
      ItemsOrders deliveryStateOrder = new ItemsOrders();
      
      model.addAttribute("deliveryStateOrder", deliveryStateOrder);
      return "orders";
    }
    
    @PostMapping("/getOtherStateOrder")
    public String placeOtherOrder(Model model) {
      
      ItemsOrders otherStateOrder = new ItemsOrders();
      
      model.addAttribute("otherStateOrder", otherStateOrder);
      return "orders";
    }
}