package project.restaurant.controllers;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.restaurant.models.Helps;
import project.restaurant.models.Users;
import project.restaurant.repository.HelpRepository;

/**
 * This class will allow a user to seek assistance from a waiter and allows a waiter to accept it.
 *
 * @author James Faraz Pete
 */
@Controller
public class HelpController {
  @Autowired
  private HelpRepository hrepo;

  /**
   * This method will allow the user to request for help if they have not already requested help.
   *
   * @param session A method to identify a user and waiter across more than one page
   * @return "help" The webpage that allows a user to request help
   */
  @GetMapping("/help")
  public String getHelp(HttpSession session) {
    Users user = (Users) session.getAttribute("user");
    if (hrepo.searchHelpByUserId(user.getUserid()) != null) {
      return "helpRequested";
    }
    return "help";
  }

  /**
   * This method will allow the waiter to accept a users' request for help.
   *
   * @param model A method to identify a help request on one webpage
   * @return "waiterhelp" The webpage that allows a waiter to accept the users help request
   */
  @GetMapping("/waiterhelps")
  public String getWaiterHelps(Model model) {
    List<Helps> lhelps = hrepo.findAll();
    model.addAttribute("helps", lhelps);
    return "waiterhelp";
  }

  /**
   * This method will store a users request for help if they have not already requested help.
   * 
   * @param session A method to identify a user and waiter across more than one page
   * @return "helpRequested" The webpage confirming to the user that their request has gone through
   */
  @PostMapping("/helpRequest")
  public String requestHelp(HttpSession session) {
    Users user = (Users) session.getAttribute("user");
    if (hrepo.searchHelpByUserId(user.getUserid()) != null) {
      return "helpRequested";
    }
    Helps newRequest = new Helps("needs help", user.getUserid());
    hrepo.save(newRequest);
    return "helpRequested";
  }

  /**
   * This method will allow a waiter to accept help and set the help request to 'helping'.
   * 
   * @param helpid The ID of the help request
   * @param model A method to identify a help request on one webpage
   * @return "waiterhelp" The webpage for a waiter to see current help requests
   */
  @GetMapping("/accepthelp")
  public String acceptHelp(@RequestParam("helpid") Integer helpid, Model model) {
    Helps helpRequest = hrepo.getReferenceById(helpid);
    helpRequest.setState("helping");
    hrepo.save(helpRequest);
    List<Helps> lhelps = hrepo.findAll();
    model.addAttribute("helps", lhelps);
    return "waiterhelp";
  }

  /**
   * This method allows a waiter to close a help request if they have completed the help request.
   * 
   * @param helpid The ID of the help request
   * @param model A method to identify a help request on one webpage
   * @return "waiterhelp" The webpage for a waiter to see current help requests
   */
  @GetMapping("/closehelp")
  public String closeHelp(@RequestParam("helpid") Integer helpid, Model model) {
    System.out.println(helpid);
    hrepo.deleteById(helpid);
    List<Helps> lhelps = hrepo.findAll();
    model.addAttribute("helps", lhelps);
    return "waiterhelp";
  }
}
