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

  @Query(value = "SELECT DISTINCT category FROM menu_items", nativeQuery = true)
  public List<String> findAllDistinctCat();

  @Query(value = "SELECT * FROM menu_items m WHERE m.category = :cat", nativeQuery = true)
  public List<MenuItems> findAllFromCat(@Param("cat")String cat);
  
  
  //@Query(value = "SELECT item_name FROM menu_items m WHERE m.itemid=itemid", nativeQuery = true)
  //public String findNameById(MenuItems itemid);
  
  @Query(value = "select T.item_name from (SELECT item_name,count(item_name) as quantity ,sum(price) as sumprice FROM menu_items m WHERE m.itemid=1 group by item_name order by sumprice desc) as T", nativeQuery = true)
  public String findNameById(MenuItems itemid);
  
  @Query(value = "select T.quantity from (SELECT item_name,count(item_name) as quantity ,sum(price) as sumprice FROM menu_items m WHERE m.itemid=1 group by item_name order by sumprice desc) as T", nativeQuery = true)
  public Integer findSumAmountById(MenuItems itemid);
  
  @Query(value = "select T.sumprice from (SELECT item_name,count(item_name) as quantity ,sum(price) as sumprice FROM menu_items m WHERE m.itemid=1 group by item_name order by sumprice desc) as T", nativeQuery = true)
  public Float findSumPriceById(MenuItems itemid);
   //@Query("SELECT o FROM MenuItems o WHERE o.itemId = ?1")
   //public List<MenuItems> findByItemId(Integer itemId);
   
}
