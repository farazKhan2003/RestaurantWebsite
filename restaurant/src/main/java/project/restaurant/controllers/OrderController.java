package project.restaurant.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.restaurant.models.Orders;
import project.restaurant.repositories.OrderRepository;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    
    /*@GetMapping("/Order")
    public List<Order> getOrder() {
        return List.of(new Order(1,1,1));
    }*/
    
    @GetMapping("/waiterinput")
    public String getWaiter(@Param("keyword") String keyword, Model model) {
      Integer waiterId = Integer.parseInt(keyword);
      List<Orders> orders = orderRepository.findByWaiterId(waiterId);
      model.addAttribute("orders", orders);
      return "order";
    }
    
    
    @GetMapping("/order")
    public String getOrders() {
      return "order";
    }
}