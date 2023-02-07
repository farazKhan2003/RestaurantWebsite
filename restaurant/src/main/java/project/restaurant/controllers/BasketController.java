package project.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import project.restaurant.repository.ItemsordersRepository;
import project.restaurant.repository.MenuItemsRepository;
import project.restaurant.repository.OrdersRepository;
import project.restaurant.repository.UsersRepository;
import project.restaurant.repository.WaitersRepository;

public class BasketController {
  @Autowired
  private MenuItemsRepository mRepo;
  
  @Autowired
  private UsersRepository uRepo;
  
  @Autowired
  private WaitersRepository wRepo;
  
  @Autowired
  private ItemsordersRepository iRepo;
  
  @Autowired
  private OrdersRepository oRepo;
  
  
}
