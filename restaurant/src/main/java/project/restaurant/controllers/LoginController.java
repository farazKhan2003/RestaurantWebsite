package project.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.restaurant.models.Users;
import project.restaurant.repository.UsersRepository;

@Controller
public class LoginController {
    @Autowired
    private UsersRepository uRepo;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/confirmLogin")
    public String confirmLogin(@RequestParam("username") String userName, @RequestParam("password") String password) {
        System.out.println("Start");
        Users user = uRepo.SearchUsersByUserOrEmailAndPassword(userName, password);
        System.out.println("hello");
        if (user == null) {
            System.out.println("if reached");
            return "loginFailed";
        }
        System.out.println("returning home");
        return "home";
    }
}