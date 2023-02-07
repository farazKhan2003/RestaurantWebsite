package project.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.restaurant.models.ItemsOrders;
import project.restaurant.models.MenuItems;
import project.restaurant.models.Orders;
import project.restaurant.models.Users;
import project.restaurant.repository.ItemsordersRepository;
import project.restaurant.repository.MenuItemsRepository;
import project.restaurant.repository.OrdersRepository;
import project.restaurant.repository.UsersRepository;
import project.restaurant.repository.WaitersRepository;

@Controller
public class BasketController {
  @Autowired
  private MenuItemsRepository mRepo;
  
  @Autowired
  private UsersRepository uRepo;
  
  @Autowired
  private WaitersRepository wRepo;
  
  @Autowired
  private ItemsordersRepository iRepo;
  
  @Autowired
  private OrdersRepository oRepo;
  
  @GetMapping("/basket")
  public String getItem(Model model) {
    System.out.println("******************************************");
    Optional<Users> user = uRepo.findById(4);
    List<Orders> orders = oRepo.findByUID(user);
    List<ItemsOrders> items = iRepo.findAllItemOrders(orders.get(0));
    
    List<String> itemsName = new ArrayList<String>();
    for(int i = 0;i<items.size();i++) {
      String mitems2 = mRepo.findNameById(items.get(i).getItemid());
      itemsName.add(mitems2);
    }
    
    List<Integer> itemsSumAmount = new ArrayList<Integer>();
    for(int i = 0;i<items.size();i++) {
      Integer mitems3 = mRepo.findSumAmountById(items.get(i).getItemid());
      itemsSumAmount.add(mitems3);
    }
    
    List<Float> itemsSumPrice = new ArrayList<Float>();
    for(int i = 0;i<items.size();i++) {
      Float mitems4 = mRepo.findSumPriceById(items.get(i).getItemid());
      itemsSumPrice.add(mitems4);
    }
    
    model.addAttribute("itemsName", itemsName);
    model.addAttribute("itemsSumAmount", itemsSumAmount);
    model.addAttribute("itemsSumPrice", itemsSumPrice);
    
    System.out.println("******************************************");
    return "basket";
  }

}
