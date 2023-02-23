package project.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.restaurant.models.Helps;

@Repository
public interface HelpRepository extends JpaRepository<Helps, Integer>{
	@Query("SELECT h FROM Helps h WHERE h.userid =?1")
	public Helps SearchHelpByUserId(@Param("userid") Integer userid);
}