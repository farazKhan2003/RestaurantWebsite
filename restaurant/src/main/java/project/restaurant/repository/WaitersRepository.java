package project.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.restaurant.models.Waiters;

@Repository
public interface WaitersRepository extends JpaRepository<Waiters, Integer>{
}
