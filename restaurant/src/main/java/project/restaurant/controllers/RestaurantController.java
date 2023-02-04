package project.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	//TEMP MAPPING WILL BE CHANGED LATER FOR FUNCTIONALITY.
	@GetMapping("/ordering-menu")
    public String getOrderMenu() {
        return "ordering-menu";
    }
}
