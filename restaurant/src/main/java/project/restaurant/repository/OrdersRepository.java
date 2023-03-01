package project.restaurant.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.restaurant.models.Orders;
import project.restaurant.models.Users;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
    @Query("SELECT o FROM Orders o WHERE o.state = 'not confirmed'")
    public List<Orders> findByState();

    @Query("SELECT o FROM Orders o WHERE o.userid = ?1")
    public List<Orders> findByUID(Optional<Users> user);

    @Query(value = "select * from orders where waiterid=:id", nativeQuery = true)
    public List<Orders> findOrderByWaiterId(int id);

    @Query(value = "select * from orders where orderid=:input", nativeQuery = true)
    public Orders findOrderByOrderId(Integer input);
    
    @Query("SELECT o FROM Orders o WHERE o.orderid = ?1")
    public List<Orders> findByOrderId(Integer orderId);
    
	@Query("SELECT o FROM Orders o WHERE o.state != ?1")
	public List<Orders> findByState(String state);

	@Query("SELECT o FROM Orders o WHERE o.state = 'Confirmed'")
    public List<Orders> findConfirmedState();
    
	@Query("SELECT o FROM Orders o WHERE o.state = 'Cooking'")
    public List<Orders> findCookingState();
	
	@Query("SELECT o FROM Orders o WHERE o.state = 'Ready'")
    public List<Orders> findReadyState();
}
