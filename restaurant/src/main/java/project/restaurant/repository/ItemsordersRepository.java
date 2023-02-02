package project.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.restaurant.models.ItemsOrders;

@Repository
public interface ItemsordersRepository extends JpaRepository<ItemsOrders,Integer>{
  @Query("")
  public void save(Integer gID,Integer orderId);
}
