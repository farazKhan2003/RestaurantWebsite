package project.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.restaurant.models.ItemsOrders;
import project.restaurant.models.MenuItems;
import project.restaurant.models.Orders;
import project.restaurant.models.Users;
import project.restaurant.models.Waiters;
import project.restaurant.repository.ItemsordersRepository;
import project.restaurant.repository.MenuItemsRepository;
import project.restaurant.repository.OrdersRepository;
import project.restaurant.repository.UsersRepository;
import project.restaurant.repository.WaitersRepository;

@Controller
public class RestaurantController {
    @Autowired
    private UsersRepository uRepo;
    
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
}
