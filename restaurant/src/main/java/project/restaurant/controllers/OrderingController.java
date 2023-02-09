package project.restaurant.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.restaurant.models.*;
import project.restaurant.repository.ItemsordersRepository;
import project.restaurant.repository.ItemsordersRepository.BasketTypeInterface;
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
          TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      return "orderingmenu";
    }
    
    @PostMapping("/placeorder2")
    public String placeOrder2(Model model) {
      if (mList.size() == 0) {
        return "havent-add-anyitem";
      }
      
      List<MenuItems> item = new ArrayList<MenuItems>();
      for(int i = 0;i<mList.size();i++) {
        item.add(mRepo.findByIntegerId(mList.get(i)).get(0));
      }
      
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
      
      System.out.println("******************************************");
      Optional<Users> user = uRepo.findById(u.getUserid());
      List<Orders> orders = oRepo.findByUID(user);
      List<ItemsOrders> items = iRepo.findAllItemOrders(orders.get(0));
      
      List<BasketTypeInterface> returnItems = iRepo.findSumAmountById(items.get(0).getOrderid().getOrderId());
      
      System.out.println("******************************************");
      System.out.println(returnItems.size());
      System.out.println("******************************************");
      
      List<BasketItem> basketOrder = new ArrayList<BasketItem>();

      Float basketTotal = (float)0;
      for(int i = 0;i<returnItems.size();i++) {
        Integer itemId = returnItems.get(i).getItemId();
        Integer itemQuantity = returnItems.get(i).getQuantity();
        Float itemSumPrice = itemQuantity*returnItems.get(i).getPrice();
        
        String itemName = mRepo.findByIntegerId(itemId).get(0).getItemName();
        basketTotal+=itemSumPrice;
        basketOrder.add(new BasketItem(itemName,itemQuantity,itemSumPrice));
      }
      
      model.addAttribute("basketOrder", basketOrder);
      model.addAttribute("basketTotal",basketTotal);
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

      List<BasketItemWithId> basketItems = new ArrayList<>();
      Float basketTotal = (float) 0;
      
      for (int i = 0; i < array.length; i++) {
        List<MenuItems> menuItem = mRepo.findByIntegerId(array[i]);
        
        Integer menuItemId = menuItem.get(0).getItemid();
        System.out.println(menuItemId);
        String name = menuItem.get(0).getItemName();
        Float price = menuItem.get(0).getPrice();
        Integer quantity = map.get(array[i]);
        
        BasketItemWithId item = new BasketItemWithId(name, quantity, price*quantity,menuItemId);
        basketTotal += (price * quantity);
        basketItems.add(item);
      }

      model.addAttribute("basketItems", basketItems);
      model.addAttribute("basketTotal", basketTotal);
      
      return "basket";
    }
    
    @GetMapping("/addRowItem")
    public String addRowItem(@Param("input") Integer input,Model model) {
      mList.add(input);
      getItem2(model);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      return "basket";
    }
    @GetMapping("/deleteRowItem")
    public String deleteRowItem(@Param("input") Integer input,Model model) {
        for(int i = 0; i < mList.size(); i++) {
            if(mList.get(i).equals(input)) {
                mList.remove(i);
                break;
            }
        }
        getItem2(model);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "basket";
    }
}
