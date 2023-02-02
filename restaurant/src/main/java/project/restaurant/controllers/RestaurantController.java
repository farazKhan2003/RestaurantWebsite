package project.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.restaurant.models.Basket;
import project.restaurant.models.MenuItems;

@Controller
public class RestaurantController {

    Basket basket = new Basket(1);

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	//TEMP MAPPING WILL BE CHANGED LATER FOR FUNCTIONALITY.
	@GetMapping("/ordering-menu")
    public String getOrderMenu() {
        return "ordering-menu";
    }
	
    @GetMapping("/basket")
    public String getBasket() {
        return "basket";
    }

    @PostMapping("add_to_basket")
    public String addToBasket(@RequestParam("itemid") Integer itemId) {
	    MenuItems item = new MenuItems(); // Needs to be changed once findMenuByItemId method is implemented
        basket.addItem(item);
        return "add_to_basket";
    }
}
