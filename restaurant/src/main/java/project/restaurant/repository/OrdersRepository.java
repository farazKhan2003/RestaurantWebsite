package project.restaurant.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.restaurant.models.KitchenStaff;
import project.restaurant.models.Orders;
import project.restaurant.models.Users;

/**
 * JpaRepository is a collection of APIs used for basic operations and sorting,
 * and OrdersRepository extends this collection to modify 'Orders' table.
 * @author Tanmeet, Peter, Irmani, Faraz, James, Wen, Pengyuan(Kenny), Daniel, Bailey
 */

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
  /**
   * selects all items from Orders where the order is not confirmed.
   * @return a list of not confirmed orders.
   */
  @Query("SELECT o FROM Orders o WHERE o.state = 'not confirmed'")
  List<Orders> findByState();

  /**
   * selects all items from Orders where state is the given parameter.
   * @param state an object of type String.
   * @return a list of Orders that satisfy the query.
   */
  @Query("SELECT o FROM Orders o WHERE o.state != ?1")
  List<Orders> findByState(String state);

  /**
   * selects all items from orders where id is the given parameter.
   * @param id an object of type int.
   * @return a list of orders that satisfy the query.
   */
  @Query(value = "select * from orders where waiterid=:id and state != 'delivered'", nativeQuery = true)
  public List<Orders> findOrderByWaiterId(int id);

  /**
   * selects all items from Orders where user is the given parameter.
   * @param user an object of type optional users.
   * @return a list of Orders that satisfy the query.
   */
  @Query("SELECT o FROM Orders o WHERE o.userid = ?1")
  List<Orders> findByuID(Optional<Users> user);

  


	@Query("SELECT o FROM Orders o WHERE o.state = 'Confirmed' Order by o.timeplaced ASC")
    public List<Orders> findConfirmedStateASC();
    
	@Query("SELECT o FROM Orders o WHERE o.state = 'Cooking' Order by o.timeplaced ASC")
    public List<Orders> findCookingStateASC();
	
	@Query("SELECT o FROM Orders o WHERE o.state = 'Ready' Order by o.timeplaced ASC")
    public List<Orders> findReadyStateASC();
    
	@Query("SELECT o FROM Orders o WHERE o.state = 'Cooking' and o.kitchenstaffid = ?1 Order by o.timeplaced ASC")
    public List<Orders> findCookingStateByKitchenStaffIdASC(KitchenStaff kstaff);

  /**
   * selects all items from orders where input is the given parameter.
   * @param input an object of type Integer.
   * @return an order satisfying the query.
   */
  @Query(value = "select * from orders where orderid=:input", nativeQuery = true)
  Orders findOrderByOrderId(Integer input);

  /**
   * selects all items from orders where orderId is the given parameter.
   * @param orderId an object of type Integer.
   * @return a list of orders that satisfy the query.
   */
  @Query("SELECT o FROM Orders o WHERE o.orderid = ?1")
  List<Orders> findByOrderId(Integer orderId);

  /**
   * selects all items from orders where state and user are the given parameters.
   * @param state an object of type String.
   * @param user an object of type Users.
   * @return a list of orders that satisfy the query.
   */
  @Query("SELECT o FROM Orders o WHERE o.state != ?1 AND o.userid = ?2")
  List<Orders> findbyStateAndID(String state, Users user);

}
