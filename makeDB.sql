DROP TABLE order_dish;
DROP TABLE dish;
DROP TABLE orders;
DROP TABLE employee;
DROP TABLE customer;
DROP TABLE types;
DROP TABLE corporate_register;
DROP TABLE categories;
DROP TABLE postalcode;


CREATE TABLE employee(
    employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	type_id INT NOT NULL,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
	clean_fn VARCHAR (30) NOT NULL,
    clean_ln VARCHAR (30) NOT NULL,
	password VARCHAR (32) NOT NULL,
    dob CHAR (11)NOT NULL,
    email VARCHAR (255)) ENGINE=InnoDB;

CREATE TABLE types(
	type_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(254) NOT NULL) ENGINE=InnoDB;
	
CREATE TABLE corporate_register(
	corporatenumber INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	corporatename VARCHAR (254) NOT NULL,
	clean_corporatename VARCHAR (254)) ENGINE=InnoDB;
   
CREATE TABLE customer (
    customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    corporatenumber INT NOT NULL,
	firstname VARCHAR (30) NOT NULL,
    lastname VARCHAR (30) NOT NULL,
	clean_fn VARCHAR (30) NOT NULL,
    clean_ln VARCHAR (30) NOT NULL,
    phonenumber VARCHAR (15) NOT NULL,
	email VARCHAR(254),
    address VARCHAR (254) NOT NULL,
    postalcode INT NOT NULL) ENGINE=InnoDB;
 
CREATE TABLE orders (
    order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    time_of_order timestamp NOT NULL,
	status VARCHAR(254)) ENGINE=InnoDB;
    
CREATE TABLE dish (
    dish_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dishname VARCHAR (30) NOT NULL,
    price DOUBLE NOT NULL,
    cost DOUBLE NOT NULL) ENGINE=InnoDB;

CREATE TABLE categories (
	cat_id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	dish_id INT NOT NULL,
	catname VARCHAR (254)) ENGINE=InnoDB;
    
CREATE TABLE order_dish (
order_id INT NOT NULL,
dish_id INT NOT NULL,
CONSTRAINT order_dish_pk PRIMARY KEY (order_id, dish_id)) ENGINE=InnoDB;

CREATE TABLE postalcode (
  postalcode int PRIMARY KEY,
  place VARCHAR (254)
) ENGINE=InnoDB;

ALTER TABLE orders
ADD CONSTRAINT orders_fk1 FOREIGN KEY(employee_id) REFERENCES employee (employee_id);

ALTER TABLE orders
ADD CONSTRAINT orders_fk2 FOREIGN KEY(customer_id) REFERENCES customer (customer_id);

ALTER TABLE order_dish
ADD CONSTRAINT order_dish_fk1 FOREIGN KEY(order_id) REFERENCES orders (order_id);

ALTER TABLE order_dish
ADD CONSTRAINT order_dish_fk2 FOREIGN KEY(dish_id) REFERENCES dish (dish_id);

ALTER TABLE employee
ADD CONSTRAINT type_fk1 FOREIGN KEY (type_id) REFERENCES types (type_id);

ALTER TABLE customer
ADD CONSTRAINT customer_fk1 FOREIGN KEY (corporatenumber) REFERENCES corporate_register (corporatenumber);

ALTER TABLE categories
ADD CONSTRAINT categories_fk1 FOREIGN KEY (dish_id) REFERENCES dish (dish_id);

ALTER TABLE

