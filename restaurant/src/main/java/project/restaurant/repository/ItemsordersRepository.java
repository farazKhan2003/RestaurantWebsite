package project.restaurant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.restaurant.models.ItemsOrders;
import project.restaurant.models.Orders;

@Repository
public interface ItemsordersRepository extends JpaRepository<ItemsOrders,Integer>{
  @Query("SELECT o FROM ItemsOrders o WHERE orderid = ?1")
  List<ItemsOrders> findAllItemOrders(Orders orders);
}
