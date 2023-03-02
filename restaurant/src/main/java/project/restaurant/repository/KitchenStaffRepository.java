package project.restaurant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.restaurant.models.KitchenStaff;

@Repository
public interface KitchenStaffRepository extends JpaRepository<KitchenStaff,Integer>{
  @Query(value = "SELECT * FROM KitchenStaff WHERE kitchenstaffid =:kitchenstaffid", nativeQuery = true)
  List<KitchenStaff> findKitchenStaffById(Integer kitchenstaffid);
}
