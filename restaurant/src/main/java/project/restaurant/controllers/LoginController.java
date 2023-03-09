package project.restaurant.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.restaurant.models.Users;
import project.restaurant.models.Waiters;
import project.restaurant.repository.UsersRepository;
import project.restaurant.repository.WaitersRepository;

/**
 * This class will allow a user/waiter to log-in given they have already signed up.
 *
 * @author James Faraz Pete
 */

@Controller
public class LoginController {
  @Autowired
  private UsersRepository urepo;

  @Autowired
  private WaitersRepository wrepo;

  /**
   * This method will allow a user/waiter to login.
   *
   * @return "login" The webpage to allow a user/waiter to login
   */

  @GetMapping("/login")
  public String getLogin() {
    return "login";
  }

  /**
   * This method will either confirm or deny an attempt at logging in
   * based on their details given compared to their details on the system.
   *
   * @param session  A method to identify a user and waiter across more than one page
   * @param userName The username for the user/waiter
   * @param password The password for the user/waiter
   * @return "loginFailed" The webpage denying a user/waiter access or
   *          "home" The webpage directing a user to the homepage after granting access or
   *          "waiterhome" The webpage directing a waiter to the waiter homepage
   */
  @PostMapping("/confirmLogin")
  public String confirmLogin(HttpSession session, @RequestParam("username") String userName,
                             @RequestParam("password") String password) {
    Users user = urepo.searchUsersByUserOrEmailAndPassword(userName, password);
    if (user == null) {
      return "loginFailed";
    }
    Waiters waiter = wrepo.searchWaitersByUserId(user);
    session.setAttribute("user", user);
    if (waiter == null) {
      return "home";
    }
    session.setAttribute("waiter", waiter);
    return "waiterhome";
  }

  /**
   * This method logs out the user/waiter.
   * @param session A method to identify a user and waiter across more than one page
   * @return "home" The homepage
   */
  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("user");
    if (session.getAttribute("waiter") != null) {
      session.removeAttribute("waiter");
    }
    return "home";
  }

  /**
   * This method will allow the waiter to access the waiter's homepage if they have access
   * otherwise direct a normal user to the default homepage.
   * @param session A method to identify a user and waiter across more than one page
   * @return "home" The default homepage
   *         "waiterhome" The waiter's homepage
   */
  @GetMapping("/waiterhome")
  public String waiterhome(HttpSession session) {
    if (session.getAttribute("waiter") == null) {
      return "home";
    }
    return "waiterhome";
  }
}
