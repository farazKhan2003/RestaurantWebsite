package project.restaurant.controllers;

import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.restaurant.models.MenuItems;
import project.restaurant.models.Users;
import project.restaurant.models.Waiters;
import project.restaurant.repository.MenuItemsRepository;
import project.restaurant.repository.UsersRepository;
import project.restaurant.repository.WaitersRepository;

@Controller
public class MenuViewController {

  @Autowired
  private MenuItemsRepository mRepo;

  @Autowired
  private UsersRepository uRepo;

  @Autowired
  private WaitersRepository wRepo;
  

  @GetMapping("/orderingmenu") 
  public String getMenuView(Model model) {
    List<MenuItems> menuItems = mRepo.findAll();
    model.addAttribute("menuItems", menuItems);
    List<String> cat = mRepo.findAllDistinctCat();
    model.addAttribute("cat", cat); 
      return "orderingmenu";
  }
  
  @PostMapping("/addItem2")
  public String postAddItem(@RequestParam("file") MultipartFile file) throws IOException {
    Users u = new Users("qwe1","qwe2","qwe3","qwe4");
    uRepo.save(u);
    Waiters waiter = new Waiters(1, u);
    wRepo.save(waiter);
    Float f = 1.25f;
    byte[] thisArray = file.getBytes();
    String fle = Base64.encodeBase64String(thisArray);
    MenuItems m = new MenuItems("ItemName1", "this is a description this is a description this is a description this is a descriptionthis is a description this is a description this is a descriptionthis is a descriptionthis is a description this is a description this is a description this is a description this is a descriptionthis is a descriptionthis is a description this is a description", f, fle , 1, waiter, "drinks", "Paprika, Curry Sauce", 450);
    mRepo.save(m);
    return "insert";
  }
  
  @GetMapping("/insert")
  public String getInserts() {
    return "insert";
  }
}
