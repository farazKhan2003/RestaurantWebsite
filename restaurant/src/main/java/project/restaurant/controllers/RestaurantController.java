package project.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
   @GetMapping("/order-confirmation")
    public String order_confirmation() {
       return "order-confirmation";
    }
}
