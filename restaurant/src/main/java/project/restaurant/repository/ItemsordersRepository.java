package project.restaurant.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.restaurant.models.BasketItem;
import project.restaurant.models.ItemsOrders;
import project.restaurant.models.MenuItems;
import project.restaurant.models.Orders;

@Repository
public interface ItemsordersRepository extends JpaRepository<ItemsOrders,Integer>{
  @Query("SELECT o FROM ItemsOrders o WHERE orderid = ?1")
  List<ItemsOrders> findAllItemOrders(Orders orders);
  
  @Query(value = "select id.itemid, id.quantity, price.price from (SELECT itemid,count(itemid) as quantity FROM itemsorders where orderid =:orderId group by itemid order by quantity desc) as id, (select itemid,price from menu_items) as price where id.itemid = price.itemid", nativeQuery = true)
  public List<BasketTypeInterface> findSumAmountById(Integer orderId);
  
  public interface BasketTypeInterface{
    Integer getItemId();
    Integer getQuantity();
    Float getPrice();
  }
}
