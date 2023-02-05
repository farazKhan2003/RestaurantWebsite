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

    //Basket basket = new Basket(1);
    
    private List<Integer> list;
    Integer orderId = 2001; //fake order id
    
    @Autowired
    private ItemsordersRepository iRepo;
    
    @Autowired
    private MenuItemsRepository mRepo;
    
    @Autowired
    private OrdersRepository oRepo;
    
    @Autowired
    private WaitersRepository wRepo;
    
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

    //@PostMapping("add_to_basket")
    //public String addToBasket(@RequestParam("itemid") Integer itemId) {
	    //MenuItems item = new MenuItems(); // Needs to be changed once findMenuByItemId method is implemented
        //basket.addItem(item);
        //return "add_to_basket";
    //}
    
    @PostMapping("/orderitem")
    public String add_item(@Param("gID") Integer gID) {
      if(list == null) {
        list = new ArrayList<Integer>();
      }
      list.add(gID);
      return "orderingmenu";
    }
    
    @PostMapping("/placeorder")
    public String placeOrder() {
      if (list == null || list.size() == 0) {
        return "havent-add-anyitem";
      }
      if (placeTheOrder() == true) {
        return "place-order-sucess";
      }else {
        return "place-order-fail";
      }
      
    }
    
     private boolean placeTheOrder() {
       Object[] array = list.toArray();
       
       for(int i=0;i<array.length;i++) {
         System.out.println("******************************************************");
         System.out.println(array[i]);
       }
       
       return true;
     }
     
     
}
