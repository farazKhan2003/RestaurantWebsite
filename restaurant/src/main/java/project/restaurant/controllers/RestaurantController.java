package project.restaurant.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.restaurant.models.Orders;

@Controller
public class RestaurantController {
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping
	public List<Orders> getOrderList() {
	  return List.of(
	     (Orders) new Orders(1,1,1));
	}
}
