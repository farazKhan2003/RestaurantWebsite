package project.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import project.restaurant.models.Helps;
import project.restaurant.models.Users;
import project.restaurant.repository.HelpRepository;

@Controller
public class HelpController {
    @Autowired
    private HelpRepository hRepo;

    @GetMapping("/help")
    public String getHelp(HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        if (hRepo.SearchHelpByUserId(user.getUserid()) != null) {
            return "helpRequested";
        }
        return "help";
    }

    @GetMapping("/waiterhelps")
    public String getWaiterHelps(Model model) {
        List<Helps> lHelps = hRepo.findAll();
        model.addAttribute("helps",lHelps);
        return "waiterhelp";
    }
    @PostMapping("/helpRequest")
    public String requestHelp(HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        if (hRepo.SearchHelpByUserId(user.getUserid()) != null) {
            return "helpRequested";
        }
        Helps newRequest = new Helps("needs help", user.getUserid());
        hRepo.save(newRequest);
        return "helpRequested";
    }

    @GetMapping("/accepthelp")
    public String acceptHelp(@RequestParam("helpid") Integer helpid, Model model) {
        Helps helpRequest = hRepo.getReferenceById(helpid);
        helpRequest.setState("helping");
        hRepo.save(helpRequest);
        List<Helps> lHelps = hRepo.findAll();
        model.addAttribute("helps",lHelps);
        return "waiterhelp";
    }

    @GetMapping("/closehelp")
    public String closeHelp(@RequestParam("helpid") Integer helpid, Model model) {
        hRepo.deleteById(helpid);
        List<Helps> lHelps = hRepo.findAll();
        model.addAttribute("helps",lHelps);
        return "waiterhelp";
    }
}