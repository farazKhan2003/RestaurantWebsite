package project.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.restaurant.models.Users;
import project.restaurant.models.Waiters;

@Repository
public interface WaitersRepository extends JpaRepository<Waiters, Integer>{
	@Query("Select w from Waiters w where w.userid = ?1")
	public Waiters SearchWaitersByUserId(Users user);
}
