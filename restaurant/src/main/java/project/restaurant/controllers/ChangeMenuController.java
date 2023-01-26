package project.restaurant.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.restaurant.models.MenuItems;
import project.restaurant.models.Orders;
import project.restaurant.repository.MenuItemsRepository;
import project.restaurant.repository.OrdersRepository;

@Controller
public class ChangeMenuController {
  @Autowired
  private MenuItemsRepository miRepo;
  @Autowired
  private OrdersRepository oRepo;
  
  @GetMapping("/menuChange")
  public String getMenuChange() {
    return "menuChange";
  }
  
  @PostMapping("/addItem")
  public String addItem(@RequestParam("itemName") String itemName, @RequestParam("description") String description, @RequestParam("price") Float price, @RequestParam(value = "img", required = false) byte[] img, @RequestParam("stockAmount") Integer stockAmount) {
    MenuItems mi;
    mi = new MenuItems(itemName, description, price, img, stockAmount, 1);
    miRepo.save(mi);
    return "home";
  }
  
  @GetMapping("/removeMenuChange")
  public String getRemoveItems() {
    return "removeMenuChange";
  }
  
  @GetMapping("/searchItems")
  public String getSearchItems(@Param("keyword") String keyword, Model model) {
    List<MenuItems> menuItems = miRepo.searchMenuItemsByKeyword("%" + keyword + "%");
    model.addAttribute("MenuItems", menuItems);
    return "removeMenuChange";
  }
 
  @GetMapping("/removeItems")
  public String getRemoveItems(@RequestParam("itemID") Integer itemID) {
    miRepo.deleteById(itemID);
    return "removeMenuChange";
  }
  
  @GetMapping("/deleteOrder")
  public String getDeleteOrder(@RequestParam("orderID") Integer orderID) {
    oRepo.deleteById(orderID);
    return "removeMenuChange";
  }
  
  @GetMapping("/orders")
  public String getOrders(Model model) {
    List<Orders> orders = oRepo.findAll();
    model.addAttribute("Orders",orders);
    return "orders";
  }
}