package project.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.restaurant.models.Itemsorders;

@Repository
public interface ItemsordersRepository extends JpaRepository<Itemsorders,Integer>{

}
