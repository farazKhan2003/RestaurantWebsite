package project.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.restaurant.repository.BasketRepository;

@Service
public class BasketService {
  
  private final BasketRepository basketRepository;

  @Autowired
  public BasketService(BasketRepository basketRepository) {
      this.basketRepository = basketRepository;
  }
}
