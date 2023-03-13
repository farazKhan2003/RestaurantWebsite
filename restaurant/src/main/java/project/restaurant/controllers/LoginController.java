package project.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import project.restaurant.models.KitchenStaff;
import project.restaurant.models.Users;
import project.restaurant.models.Waiters;
import project.restaurant.repository.KitchenStaffRepository;
import project.restaurant.repository.UsersRepository;
import project.restaurant.repository.WaitersRepository;

@Controller
public class LoginController {
    @Autowired
    private UsersRepository uRepo;

    @Autowired
    private WaitersRepository wRepo;
    
    @Autowired
    private KitchenStaffRepository kRepo;
    
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/confirmLogin")
    public String confirmLogin(HttpSession session, @RequestParam("username") String userName, @RequestParam("password") String password) {
        Users user = uRepo.SearchUsersByUserOrEmailAndPassword(userName, password);
        if (user == null) {
            return "loginFailed";
        }
        Waiters waiter = wRepo.SearchWaitersByUserId(user);
        KitchenStaff kitchenstaff = kRepo.findKitchenStaffByUID(user);
        session.setAttribute("user",user);
        if(waiter==null && kitchenstaff==null) {
        	return "home";
        }
        if(waiter != null) {
          session.setAttribute("waiter", waiter);
          return "waiterhome";
        }
        session.setAttribute("kitchenstaff", kitchenstaff);
        return "kitchenStaffHome";
    }
    
    @PostMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user");
    	if(session.getAttribute("waiter")!=null) {
    		session.removeAttribute("waiter");
    	}
    	if(session.getAttribute("kitchenstaff")!=null) {
          session.removeAttribute("kitchenstaff");
        }
    	return "home";
    }
    
    @GetMapping("/waiterhome")
    public String waiterhome(HttpSession session){
    	if(session.getAttribute("waiter")==null) {
    		return "home";
    	}
    	return "waiterhome";
    }

    @GetMapping("/kitchenStaffHome")
    public String kitchenStaffHome(HttpSession session) {
        if (session.getAttribute("kitchenstaff")==null) {
            return "home";
        }
        return "kitchenStaffHome";
    }
}
