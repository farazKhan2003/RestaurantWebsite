package project.restaurant.controllers;

import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import project.restaurant.models.Helps;
import project.restaurant.models.Users;
import project.restaurant.repository.HelpRepository;

@Controller
public class HelpController {
    @Autowired
    private HelpRepository hRepo;

    @GetMapping("/help")
    public String getHelp(Model model) {
        return "help";
    }



    @PostMapping("/helpRequest")
    public String requestHelp(HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        Helps newRequest = new Helps("needs help", user.getUserid());
        System.out.println(user.getUsername() + user.getPasswords() + user.getUserid() + user.getUsertype());
        hRepo.save(newRequest);
        return "helpRequested";
    }
}