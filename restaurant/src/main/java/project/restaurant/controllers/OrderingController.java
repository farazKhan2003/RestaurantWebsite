package project.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class OrderingController {
    
    private List<Integer> mList = new ArrayList<Integer>();
    
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
    
    @PostMapping("/orderitem2")
    public String addOrderItem(@RequestParam("aMenuItem") Integer aMenuItem, Model model) {
      mList.add(aMenuItem);
      for(Integer m:mList) {
        System.out.println(m);
      }
      
      List<MenuItems> menuItems = mRepo.findAll();
      model.addAttribute("menuItems", menuItems);
      List<String> cat = mRepo.findAllDistinctCat();
      model.addAttribute("cat", cat); 
      
      return "orderingmenu";
    }
    
    @PostMapping("/placeorder2")
    public String placeOrder2() {
      if (mList.size() == 0) {
        return "havent-add-anyitem";
      }
      List<MenuItems> item = mRepo.findAllById(mList);
      
      Users u = new Users("qwe1","qwe2","qwe3","qwe4");
      uRepo.save(u);
      Waiters waiter = new Waiters(1, u);
      wRepo.save(waiter);
      Orders order = new Orders("not confirmed",waiter,u);
      oRepo.save(order);
      
      for(MenuItems i:item) {
        iRepo.save(new ItemsOrders(i,order));
      }
      mList.clear();
      return "place-order-sucess";
    }
}
