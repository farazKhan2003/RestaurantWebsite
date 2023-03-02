package project.restaurant.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.restaurant.models.BasketItemWithId;
import project.restaurant.models.ItemsOrders;
import project.restaurant.models.KitchenStaff;
import project.restaurant.models.MenuItems;
import project.restaurant.models.Orders;
import project.restaurant.models.Users;
import project.restaurant.repository.ItemsordersRepository;
import project.restaurant.repository.KitchenStaffRepository;
import project.restaurant.repository.MenuItemsRepository;
import project.restaurant.repository.OrdersRepository;

@Controller
public class KitchenStaffController {

    @Autowired
    private OrdersRepository oRepo;
    
    @Autowired
    private ItemsordersRepository iRepo;
    
    @Autowired
    private MenuItemsRepository mRepo;
    
    @Autowired
    private KitchenStaffRepository kRepo;
    
    @GetMapping("/kitchenStaffOrders")
    public String getKitchenOrders(Model model) {
      
      List<Orders> ConfirmedStateOrder = oRepo.findConfirmedStateASC();
      List<Orders> CookingStateOrder = oRepo.findCookingStateASC();
      List<Orders> ReadyStateOrder = oRepo.findReadyStateASC();
      
      System.out.println(ConfirmedStateOrder.size());
      System.out.println(CookingStateOrder.size());
      System.out.println(ReadyStateOrder.size());
      
      model.addAttribute("ConfirmedStateOrder", ConfirmedStateOrder);
      model.addAttribute("CookingStateOrder", CookingStateOrder);
      model.addAttribute("ReadyStateOrder", ReadyStateOrder);
      
      return "kitchenStaffOrders";
    }

    @PostMapping("/changeToCooking")
    public String changeStateToCooking(@Param("input") Integer input, Model model) {
        Orders order = oRepo.findOrderByOrderId(input);
        order.setState("cooking");
        
        List<KitchenStaff> kstaff = kRepo.findKitchenStaffById(1);
        System.out.println("****************************************");
        System.out.println(kstaff.size());
        System.out.println("****************************************");
        order.setOkitchenStaffId(kstaff.get(0));
        oRepo.save(order);
        System.out.println("****************************************");
        System.out.println(order.getOkitchenStaffId().getKitchenStaffId());
        System.out.println("****************************************");
        getKitchenOrders(model);
        return "kitchenStaffOrders";
    }

    @PostMapping("/changeToReady")
    public String changeStateToReady(@Param("input") Integer input, Model model) {
        Orders order = oRepo.findOrderByOrderId(input);
        order.setState("ready");
        oRepo.save(order);
        getKitchenOrders(model);
        return "kitchenStaffOrders";
    }
    
    @PostMapping("/viewDetail")
    public String viewOrderDetail(@Param("input") Integer input, Model model) {
        System.out.println("****************************************");
        System.out.println(input);
        System.out.println("****************************************");
        getOrderDetail(input, model);
        return "orderdetail";
    }
    
    @GetMapping("/orderdetail")
    public String getOrderDetail(@Param("input") Integer input, Model model) {
      
      System.out.println("****************************************");
      System.out.println(input);
      System.out.println("****************************************");
      
      List<ItemsOrders> items = iRepo.findAllItemOrders(oRepo.findOrderByOrderId(input));
      
      System.out.println("****************************************");
      System.out.println(items.size());
      System.out.println("****************************************");
      
      List<Integer> menuitemid = new ArrayList<Integer>();
      for(int i = 0; i<items.size(); i++) {
        menuitemid.add(items.get(i).getItemid().getItemid());
      }
      
      System.out.println("****************************************");
      System.out.println(menuitemid.size());
      System.out.println("****************************************");
      
      Set<Integer> set = new TreeSet<Integer>(menuitemid);

      Integer[] array = new Integer[set.size()];

      Iterator<Integer> iterator = set.iterator();

      int j = 0;
      while (iterator.hasNext()) {
          array[j] = iterator.next();
          j++;
      }

      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < menuitemid.size(); i++) {
          if (map.containsKey(menuitemid.get(i)) == false) {
              map.put(menuitemid.get(i), 1);
          } else {
              map.put(menuitemid.get(i), map.get(menuitemid.get(i)) + 1);
          }
      }

      List<BasketItemWithId> Items = new ArrayList<>();

      for (int i = 0; i < array.length; i++) {
          List<MenuItems> menuItem = mRepo.findByIntegerId(array[i]);

          Integer menuItemId = menuItem.get(0).getItemid();
          System.out.println(menuItemId);
          String name = menuItem.get(0).getItemName();
          Float price = menuItem.get(0).getPrice();
          Integer quantity = map.get(array[i]);

          BasketItemWithId item = new BasketItemWithId(name, quantity, price * quantity, menuItemId);
          Items.add(item);
      }
      
      System.out.println("****************************************");
      System.out.println(Items.size());
      System.out.println("****************************************");
      
      model.addAttribute("Items", Items);
      
      return "orderdetail";
    }
    
}
