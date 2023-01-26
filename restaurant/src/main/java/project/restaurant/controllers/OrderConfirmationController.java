package project.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderConfirmationController {

  @GetMapping("/order-confirmation")
  public String orderConfirmation() {
     return "order-confirmation";
  }
  
  @GetMapping("/confirmOrder")
  public String confirmOrder() {
    //When customer table is complete, action will change value of confirmed in DB to true.
    //repo.confirmOrder(true);
    return "confirm-success";
  }
  
}
