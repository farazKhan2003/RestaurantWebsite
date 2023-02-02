package project.restaurant.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.restaurant.models.Basket;
import project.restaurant.models.MenuItems;
import project.restaurant.repository.ItemsordersRepository;

@Controller
public class RestaurantController {

    Basket basket = new Basket(1);
    
    private List<Integer> list;
    
    @Autowired
    private ItemsordersRepository iRepo;
    
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
    
    @PostMapping("/orderitem")
    public String add_item(@Param("gID") Integer gID) {
      list.add(gID);
      return "ordering_menu";
    }
    
    @PostMapping("/placeorder")
    public String placeOrder() {
      if (placeTheOrder() == true) {
        return "place_order_sucess";
      }else {
        return "place_order_fail";
      }
      
    }
    
    private boolean placeTheOrder() {
      return true;
    }
}
