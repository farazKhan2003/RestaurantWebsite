package project.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.restaurant.models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
