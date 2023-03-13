package project.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.restaurant.models.Users;
import project.restaurant.repository.UsersRepository;

@Controller
public class SignUpController {
    @Autowired
    private UsersRepository uRepo;

    @GetMapping("/signup")
    public String getSignUp() {
        return "signup";
    }

    @PostMapping("/signingup")
    public String getSearchUsers(@RequestParam("username") String userName, @RequestParam("email") String emailAddress, @RequestParam("password") String passWord) {
        String msg;
        if(uRepo.SearchUsersByUser(userName) == null && uRepo.SearchUsersByEmail(emailAddress) == null) {
            Users user = new Users("0", userName, passWord, emailAddress);
            uRepo.save(user);
            msg = "home";
        }
        else {
            msg = "signupFailed";
        }
        return msg;
    }
}