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

  @Query("SELECT u FROM Users u WHERE u.email_address =?1")
  public Users SearchUsersByEmail(@Param("email_address") String email_address);

  @Query("SELECT u FROM Users u WHERE u.username =?1")
  public Users SearchUsersByUser(@Param("username") String username);

  @Query("SELECT u FROM Users u WHERE (u.email_address =?1 OR u.username =?1) AND u.passwords = ?2")
  public Users SearchUsersByUserOrEmailAndPassword(@Param("username") String username, @Param("password") String password);
}