package project.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderStateController {

    @GetMapping("/orders")
    public String getOrders() {
        return "orders";
    }

}