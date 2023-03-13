package project.restaurant.controllers;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * This class will display the menu for users.
 *
 * @author James Faraz Pete Bailey Dan Tanmeet Kenny Irmani Wen
 */

@Controller
public class MenuViewController {

  @Autowired
  private MenuItemsRepository mrepo;

  @Autowired
  private UsersRepository urepo;

  @Autowired
  private WaitersRepository wrepo;

  /**
   * This method will display the menu.
   *
   * @param model A method to identify a menu item and category on one webpage
   * @return "orderingmenu" The webpage to see the full menu of dishes
   */
  @GetMapping("/orderingmenu")
  public String getMenuView(Model model) {
    List<MenuItems> menuItems = mrepo.findAll();

    List<String> priceList = new ArrayList<>();

    for (MenuItems mi : menuItems) {
      String str = mi.getPrice() + ""; // connverting int to string
      String digit = str.substring(str.length() - 2, str.length());
      String frontDigit = str.substring(0, str.length() - 2);
      System.out.println(digit);
      if (digit.equals(".0") || digit.equals(".1") || digit.equals(".2") || digit.equals(".3")
          || digit.equals(".4") || digit.equals(".5") || digit.equals(".6") || digit.equals(".7")
          || digit.equals(".8") || digit.equals(".9")) {
        digit = digit + "0";
        frontDigit = frontDigit + digit;
        // basketTotal = Float.parseFloat(frontDigit);
      } else {
        frontDigit = str;
      }
      priceList.add(frontDigit);

    }
    model.addAttribute("priceList", priceList);

    model.addAttribute("menuItems", menuItems);
    List<String> cat = mrepo.findAllDistinctCat();
    model.addAttribute("cat", cat);
    return "orderingmenu";
  }

  /**
   * This method will allow an item to be added onto the menu.
   *
   * @param file The image of the menu item
   * @return "insert" The webpage for inserting a menu item
   * @throws IOException If the image provided is not in the correct format then it will throw an
   *         IOExcception
   */
  @PostMapping("/addItem2")
  public String postAddItem(@RequestParam("file") MultipartFile file) throws IOException {
    Users u = new Users("qwe2", "waiter", "password123", "qwe5");
    urepo.save(u);
    Waiters waiter = new Waiters(1, u);
    wrepo.save(waiter);
    Float f = 1.25f;
    byte[] thisArray = file.getBytes();
    String fle = Base64.encodeBase64String(thisArray);
    MenuItems m = new MenuItems("ItemName1", "this is a description this is a description "
        + "this is a description this is a descriptionthis is a description "
        + "this is a description this is a descriptionthis is a descriptionthis is a description "
        + "this is a description this is a description this is a description "
        + "this is a descriptionthis is a descriptionthis is a description this is a description",
        f, fle, 1, waiter, "drinks", "Paprika, Curry Sauce", 450);
    mrepo.save(m);
    return "insert";
  }

  /**
   * This method will redirect the user to the inserts page.
   *
   * @return "insert" The webpage for inserting menu items
   */

  @GetMapping("/insert")
  public String getInserts() {
    return "insert";
  }
}
