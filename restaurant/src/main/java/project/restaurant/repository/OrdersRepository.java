package project.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.restaurant.models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	@Query("SELECT o FROM Orders o WHERE o.state != 3")
	public List<Orders> findByState();

}
