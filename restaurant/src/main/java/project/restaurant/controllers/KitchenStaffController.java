package project.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.restaurant.repository.OrdersRepository;

@Controller
public class KitchenStaffController {

    @Autowired
    private OrdersRepository oRepo;

}
