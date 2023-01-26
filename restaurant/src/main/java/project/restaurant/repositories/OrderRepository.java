package project.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.restaurant.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
