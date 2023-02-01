package project.restaurant;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.annotation.Resource;
import project.restaurant.models.Orders;
import project.restaurant.services.OrderService;

@SpringBootTest
class TestForOrdersService {
  
  @Resource
  private OrderService orderService;
  
  @Test
  void testGetOrders() {
    List<Orders> list = orderService.getOrders();
    System.out.println(list);
  }

}