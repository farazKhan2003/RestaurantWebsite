package project.restaurant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.restaurant.models.KitchenStaff;
import project.restaurant.models.Users;
import project.restaurant.models.Waiters;

@Repository
public interface KitchenStaffRepository extends JpaRepository<KitchenStaff,Integer>{
  @Query(value = "SELECT * FROM kitchen_staff WHERE kitchenstaffid =:kitchenstaffid", nativeQuery = true)
  List<KitchenStaff> findKitchenStaffById(Integer kitchenstaffid);
  
  @Query(value = "SELECT k FROM KitchenStaff k WHERE k.userid =?1")
  public KitchenStaff findKitchenStaffByUID(Users userid);
  
}
