package project.restaurant.controllers;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.restaurant.models.MenuItems;
import project.restaurant.repository.MenuItemsRepository;

@Controller
public class MenuViewController {

  @Autowired
  private MenuItemsRepository mRepo;
  

  @GetMapping("/orderingmenu") 
  public String getMenuView(Model model) {
    List<MenuItems> menuItems = mRepo.findAll();
    model.addAttribute("menuItems", menuItems);
    List<String> cat = mRepo.findAllDistinctCat();
    model.addAttribute("cat", cat); 
      return "orderingmenu";
  }
}
