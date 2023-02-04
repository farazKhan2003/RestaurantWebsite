package project.restaurant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.restaurant.models.MenuItems;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItems, Integer>{
   @Query(value = "SELECT * FROM menu_items m WHERE m.item_name LIKE :keyword OR m.descriptions LIKE :keyword", nativeQuery = true)
   public List<MenuItems> searchMenuItemsByKeyword(@Param("keyword") String keyword);
   
   //@Query("SELECT o FROM MenuItems o WHERE o.itemId = ?1")
   //public List<MenuItems> findByItemId(@Param("id") Integer itemId);
   
}