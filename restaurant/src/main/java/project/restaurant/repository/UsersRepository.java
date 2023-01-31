package project.restaurant.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.restaurant.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
  @Query("SELECT u FROM Users u WHERE u.usertype =?1")
  public List<Users> SearchUsersByType(@Param("usertype") String usertype);
}