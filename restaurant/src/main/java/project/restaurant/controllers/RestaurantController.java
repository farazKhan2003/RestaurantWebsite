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
      return "ordering-menu";
    }
    
    @PostMapping("/placeorder")
    public String placeOrder() {
      if (placeTheOrder() == true) {
        return "place-order-sucess";
      }else {
        return "place-order-fail";
      }
      
    }
    
    //private boolean placeTheOrder() {
      //Integer[] array = (Integer[]) list.toArray();
      //for(int i = 0; i<array.length; i++) {
        //ItemsOrders order = new ItemsOrders();
        //List<MenuItems> item = mRepo.findByItemId(array[i]);//need to have a fake item have 1001 as its itemid
        //order.setItemid(item.get(0));
        //List<Orders> orderObject = oRepo.findByOrderId(orderId);
        //order.setOrderid(orderObject.get(0));
        //iRepo.save(order);
      //}
      //return true;
    //}
    
    //a fake placeTheOrder
    //private boolean placeTheOrder() {
      //Object[] array = list.toArray();
      
      //for(int i=0;i<array.length;i++) {
        //System.out.println(array[i]);
      //}
      
      //byte[] file = new byte[2];
      //Users u = new Users("qwe1","qwe2","qwe3","qwe4");
      //u.setUserid(1001);
      //uRepo.save(u);
      
      //Waiters waiter = new Waiters(1, u);
      //waiter.setItemid(1001);
      //wRepo.save(waiter);
      
      //Float f = new Float(1.25);
      //MenuItems m = new MenuItems("ItemName1", "this is a description", f, file, 1, waiter, "curry", "Paprika, Curry Sauce", 450);
      //m.setItemid(1001);
      //mRepo.save(m);
      
      //Orders orders = new Orders("cooking", waiter, u);
      //orders.setOrderId(1001);
      
      //ItemsOrders itemorder = new ItemsOrders(m,orders);
      //itemorder.setItemordersid(1001);
      //iRepo.save(itemorder);
      
      //return true;
    //}
    
      //another fake placeTheOrder
     private boolean placeTheOrder() {
       Object[] array = list.toArray();
       
       for(int i=0;i<array.length;i++) {
         System.out.println(array[i]);
       }
       
       return true;
     }
}
