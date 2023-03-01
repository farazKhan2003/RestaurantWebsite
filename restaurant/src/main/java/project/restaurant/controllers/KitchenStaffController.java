package project.restaurant.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.restaurant.models.Orders;
import project.restaurant.repository.OrdersRepository;

@Controller
public class KitchenStaffController {

    @Autowired
    private OrdersRepository oRepo;
    
    @GetMapping("/kitchenStaffOrders")
    public String getWaitForCookOreders(Model model) {
      
      List<Orders> ConfirmedStateOrder = oRepo.findConfirmedState();
      List<Orders> CookingStateOrder = oRepo.findCookingState();
      List<Orders> ReadyStateOrder = oRepo.findReadyState();
      
      System.out.println(ConfirmedStateOrder.size());
      System.out.println(CookingStateOrder.size());
      System.out.println(ReadyStateOrder.size());
      
      model.addAttribute("ConfirmedStateOrder", ConfirmedStateOrder);
      model.addAttribute("CookingStateOrder", CookingStateOrder);
      model.addAttribute("ReadyStateOrder", ReadyStateOrder);
      
      return "kitchenStaffOrders";
    }
    
}
