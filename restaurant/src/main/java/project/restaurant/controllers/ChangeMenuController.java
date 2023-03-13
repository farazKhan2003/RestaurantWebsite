package project.restaurant.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import project.restaurant.models.MenuItems;
import project.restaurant.models.Waiters;
import project.restaurant.repository.MenuItemsRepository;

@Controller
public class ChangeMenuController {
  @Autowired
  private MenuItemsRepository miRepo;
  
  @GetMapping("/menuChange")
  public String getMenuChange() {
    return "menuChange";
  }
  @GetMapping("/addItem")
  public String addItem() {
	  return "addItem";
  }
  @PostMapping("/addItems")
  public String addItems(HttpSession session,@RequestParam("itemName") String itemName, @RequestParam("description") String description, @RequestParam("price") Float price, @RequestParam("file") MultipartFile file, @RequestParam("stockAmount") Integer stockAmount, @RequestParam("category")String category, @RequestParam("ingredients") String ingredients, @RequestParam("calories") Integer calories) throws IOException {
	byte[] thisArray = file.getBytes();
	String fle = Base64.encodeBase64String(thisArray);
	Waiters waiter = (Waiters) session.getAttribute("waiter");
	MenuItems mi = new MenuItems(itemName, description, price, fle, stockAmount, waiter, category, ingredients, calories);
    miRepo.save(mi);
    return "menuChanges";
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
  
  @PostMapping("/viewMenu")
  public String getViewMenu(Model model) {
	  List<MenuItems> menuItems = miRepo.findAll();
	  model.addAttribute("menuItems", menuItems);
	  List<String> cat = miRepo.findAllDistinctCat();
	  model.addAttribute("cat", cat); 
	  return "viewMenu";
  }
  
  @PostMapping("/editRemoveMenu")
  public String getEditRemoveMenu(Model model) {
	  List<MenuItems> menuItems = miRepo.findAll();
	  model.addAttribute("menuItems", menuItems);
	  List<String> cat = miRepo.findAllDistinctCat();
	  model.addAttribute("cat", cat);
	  return "editRemoveMenu";
  }
  @PostMapping("/removeItem")
  public String getRemoveItem(@RequestParam("aMenuItem")Integer itemid) {
	  miRepo.deleteById(itemid);
	  return "menuChanges"; 
  }
  
  @PostMapping("/editItem")
  public String getEditItem(@RequestParam("aMenuItem")Integer itemid, Model model) {
	  MenuItems mi = miRepo.findBySingleId(itemid);
	  model.addAttribute("menuItem",mi);
	  return "editSpecificItem";
  }
  
  @PostMapping("/updateItems")
  public String getUpdateItem(@RequestParam("aMenuItem")Integer itemid, HttpSession session,@RequestParam("itemName") String itemName, @RequestParam("description") String description, @RequestParam("price") Float price, @RequestParam("file") MultipartFile file, @RequestParam("stockAmount") Integer stockAmount, @RequestParam("category")String category, @RequestParam("ingredients") String ingredients, @RequestParam("calories") Integer calories) throws IOException {
	  Waiters waiter = (Waiters) session.getAttribute("waiter");
	  byte[] thisArray = file.getBytes();
	  String fle = Base64.encodeBase64String(thisArray);	 
	  MenuItems mi = miRepo.findBySingleId(itemid);
	  mi.setItemName(itemName);
	  mi.setDescriptions(description);
	  mi.setPrice(price);
	  mi.setImg(fle);
	  mi.setStockAmount(stockAmount);
	  mi.setWaiterid(waiter);
	  mi.setCategory(category);
	  mi.setIngredients(ingredients);
	  mi.setCalories(calories);
	  miRepo.save(mi);
	  return "menuChanges";
  }
	  
 
}
