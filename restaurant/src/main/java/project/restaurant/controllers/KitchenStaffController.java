package project.restaurant.controllers;

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
public class KitchenStaffController {

    @Autowired
    private OrdersRepository oRepo;
    
    @GetMapping("/kitchenStaffOrders")
    public String getKitchenOrders(Model model) {
      
      List<Orders> ConfirmedStateOrder = oRepo.findConfirmedState();
      List<Orders> CookingStateOrder = oRepo.findCookingState();
      List<Orders> ReadyStateOrder = oRepo.findReadyState();
      
      System.out.println(ConfirmedStateOrder.size());
      System.out.println(CookingStateOrder.size());
      System.out.println(ReadyStateOrder.size());
      
      model.addAttribute("ConfirmedStateOrder", ConfirmedStateOrder);
      model.addAttribute("ConokingStateOrder", CookingStateOrder);
      model.addAttribute("ReadyStateOrder", ReadyStateOrder);
      
      return "kitchenStaffOrders";
    }

    @PostMapping("/changeToCooking")
    public String changeStateToDelivered(@Param("input") Integer input, Model model) {
        Orders order = oRepo.findOrderByOrderId(input);
        order.setState("cooking");
        oRepo.save(order);
        getKitchenOrders(model);
        return "kitchenStaffOrders";
    }

    @PostMapping("/changeToReady")
    public String changeStateToReady(@Param("input") Integer input, Model model) {
        Orders order = oRepo.findOrderByOrderId(input);
        order.setState("ready");
        oRepo.save(order);
        getKitchenOrders(model);
        return "kitchenStaffOrders";
    }
}
