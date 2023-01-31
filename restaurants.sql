DROP DATABASE IF EXISTS cs2810restaurant;
CREATE DATABASE IF NOT EXISTS cs2810restaurant;
USE cs2810restaurant;

create table users(
    userid integer not null auto_increment,
    usertype text not null,
    username text not null,
    passwords text(64) not null,
    email_address text not null,
    primary key(userid)
)engine=MyISAM ;

create table waiters(
    waiterid integer not null auto_increment,
    permissions integer not null,
    primary key(waiterid),
    constraint waiterids
    foreign key (waiterid)
    references cs2810restaurant.users (userid)
    on delete set NULL
    on update no action
)  engine=MyISAM; 
    
create table menu_items (
	itemid integer not null auto_increment,
	descriptions varchar(255) not null,
	img longblob,
	item_name varchar(255) not null,
	price float not null,
	stock_amount integer,
    category text not null,
	waiterid integer not null,
    ingredients text not null,
    calories integer not null,
    primary key (itemid),
	constraint waiteritem
    foreign key (waiterid)
    references cs2810restaurant.waiters (waiterid)
    on delete set NULL
    on update no action
) engine=MyISAM ;

CREATE TABLE IF NOT EXISTS orders (
  orderid INT NOT NULL AUTO_INCREMENT,
  state TEXT NOT NULL,
  waiterid INT NOT NULL,
  userid INT NOT NULL,
  primary key (orderid),
  constraint orderswaiter
    foreign key (waiterid)
    references cs2810restaurant.waiters (waiterid)
    on delete set NULL
    on update no action,
  constraint orderuser
    foreign key (userid)
    references cs2810restaurant.users (userid)
    on delete set NULL
    on update no action
)engine = MyISAM; 

create table if not exists itemsorders(
  itemsordersid int not null auto_increment,
  itemid int not null,
  orderid int not null,
  primary key(itemsordersid),
  constraint itemsordersitem
  foreign key (itemid)
  references cs2810restaurant.menu_items(itemid)
  on delete set NULL
  on update no action,
  constraint itemsordersorder
  foreign key(orderid)
  references cs2810restaurant.orders(orderid)
) engine=MyISAM;


