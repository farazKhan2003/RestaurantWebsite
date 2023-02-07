package project.restaurant.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
      try {
          TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
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
    
    @GetMapping("/basket")
    public String getItem2(Model model) {
      
      Set<Integer> set = new TreeSet<Integer>(mList);
      
      Integer[] array = new Integer[set.size()];
      
      Iterator<Integer> iterator = set.iterator();
      
      int j = 0;
      while(iterator.hasNext()){
        array[j] = iterator.next();
        j++;
      }
      
      Map<Integer,Integer> map = new HashMap<>();
      
      for(int i = 0;i<mList.size();i++) {
        if(map.containsKey(mList.get(i)) == false) {
          map.put(mList.get(i), 1);
        } else {
          map.put(mList.get(i), map.get(mList.get(i))+1);
        }
      }
      
      List<String> menuItemName = new ArrayList<String>();
      List<Integer> menuItemAmount = new ArrayList<Integer>();
      List<Float> menuItemPrice = new ArrayList<Float>();
      
      for(int i = 0;i<array.length;i++) {
        List<MenuItems> menuItem = mRepo.findByIntegerId(array[i]);
        String name = menuItem.get(0).getItemName();
        Float price = menuItem.get(0).getPrice();
        menuItemName.add(name);
        menuItemAmount.add(map.get(array[i]));
        menuItemPrice.add(price*menuItemAmount.get(i));
      }
      
      System.out.println(menuItemName.size());
      model.addAttribute("itemsName", menuItemName);
      model.addAttribute("itemsSumAmount", menuItemAmount);
      model.addAttribute("itemsSumPrice",  menuItemPrice);
      
      System.out.println("******************************************");
      return "basket";
    }
}
