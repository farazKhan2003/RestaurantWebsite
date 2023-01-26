package project.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.restaurant.models.Orders;

public interface OrdersRepostitory extends JpaRepository<Orders, Integer> {
  //@Query("INSERT INTO Orders(confirmed) VALUES(true);")
  //public Boolean confirmOrder(Boolean confirmed);
}

//SQL code for test table:
//
//DROP DATABASE IF EXISTS cs2810restaurant;
//CREATE DATABASE IF NOT EXISTS cs2810restaurant;
//USE cs2810restaurant;
//CREATE TABLE IF NOT EXISTS `cs2810restaurant`.`Orders` (
//    `orderId` INT NOT NULL AUTO_INCREMENT,
//    `confirmed` BOOLEAN NOT NULL,
//    PRIMARY KEY (`orderId`)
//)