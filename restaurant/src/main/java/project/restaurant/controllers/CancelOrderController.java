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
import project.restaurant.models.Users;
import project.restaurant.models.Waiters;
import project.restaurant.repository.OrdersRepository;

@Controller
public class CancelOrderController {
  
  @Autowired
  private OrdersRepository orepo;
  
  @GetMapping("/customerCancelOrders")
  public String getCancelOrders(Model model, HttpSession session) {
    Users user = (Users) session.getAttribute("user");
    List<Orders> cancelOrder = orepo.findNotComfirmedAndComfirmedOrdersByUserId(user);
    model.addAttribute("cancelOrder", cancelOrder);
    return "customerCancelOrders";
  }
  
  @PostMapping("/tryToCancel")
  public String changeStateToDelivered(@Param("input") Integer input, Model model, HttpSession session) {
    Orders order = orepo.findOrderByOrderId(input);
    order.setState("canceling");
    orepo.save(order);
    getCancelOrders(model, session);
    return "customerCancelOrders";
  }
}
