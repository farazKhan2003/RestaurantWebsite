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
  
  //Note that you need to insert corresponding order into database first
  @Test
  void testIfSpecificOrderExist() {
    Integer orderNumber = 1001;
    List<Orders> list = orderService.getOrders();
    Boolean test = false;
    
    Orders[] array = new Orders[list.size()];
    list.toArray(array);
    
    for(int i = 0; i<array.length ; i++) {
      Integer number = array[i].getOrderNumber();
      if(number.equals(orderNumber)) {
        test = true;
      }
    }
    assertTrue(test,"You need to insert corresponding order into database first!");
  }
}