package project.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.restaurant.models.Helps;

@Repository
public interface HelpRepository extends JpaRepository<Helps, Integer> {

}