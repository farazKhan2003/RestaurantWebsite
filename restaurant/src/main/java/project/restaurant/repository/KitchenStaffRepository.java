package project.restaurant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.restaurant.models.KitchenStaff;
import project.restaurant.models.Users;

@Repository
public interface KitchenStaffRepository extends JpaRepository<KitchenStaff,Integer>{
  @Query(value = "SELECT * FROM kitchen_staff WHERE kitchenstaffid =:kitchenstaffid", nativeQuery = true)
  List<KitchenStaff> findKitchenStaffById(Integer kitchenstaffid);
  
  @Query(value = "SELECT * FROM kitchen_staff WHERE userid =:userid", nativeQuery = true)
  List<KitchenStaff> findKitchenStaffByUID(Integer userid);
}
