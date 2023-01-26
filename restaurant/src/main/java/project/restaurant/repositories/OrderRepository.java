package project.restaurant.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.restaurant.models.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
  
  @Query("SELECT o FROM Orders o WHERE o.waiterId = ?1")
  public List<Orders> findByWaiterId(Integer waiter_Id);
}
