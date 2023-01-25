package project.restaurant.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.restaurant.models.Order;

@Controller
public class RestaurantController {
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping
	public List<Order> getOrderList() {
	  return List.of(
	     (Order) new Order(1,1,1));
	}
}
