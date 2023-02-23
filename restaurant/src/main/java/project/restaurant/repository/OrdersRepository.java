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
	@Query("SELECT o FROM Orders o WHERE o.state != 3")
	public List<Orders> findByState();
	
	@Query("SELECT o FROM Orders o WHERE o.userid = ?1")
    public List<Orders> findByUID(Optional<Users> user);
    
    @Query(value = "SELECT DISTINCT orderid FROM orders", nativeQuery = true)
    public List<String> findAllDistinctID();
    
    @Query("SELECT o FROM Orders o WHERE o.state != ?1")
    public List<Orders> findByState(String state);
}

