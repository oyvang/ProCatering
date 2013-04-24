-- DROP TABLE cat_dish;
-- DROP TABLE categories;
-- DROP TABLE order_dish;
-- DROP TABLE dish;
-- DROP TABLE orders;
-- DROP TABLE employee_types;
-- DROP TABLE types;
-- DROP TABLE customer;
-- DROP TABLE corporate_register;
-- DROP TABLE employee;
-- DROP TABLE postalcode

CREATE TABLE employee(
    employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    clean_fn VARCHAR (255) NOT NULL,
    clean_ln VARCHAR (255) NOT NULL,
    password VARCHAR (32) NOT NULL,
    phonenumber VARCHAR (30) NOT NULL,
    postalcode INT NOT NULL,
    dob CHAR (11)NOT NULL,
    email VARCHAR (255) NOT NULL) ENGINE=InnoDB;

CREATE TABLE types(
    type_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL) ENGINE=InnoDB;
	
CREATE TABLE corporate_register(
    corporatenumber INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    corporatename VARCHAR (255) NOT NULL,
    clean_corporatename VARCHAR (255)) ENGINE=InnoDB;
   
CREATE TABLE customer (
    customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    corporatenumber INT NOT NULL DEFAULT 0,
    firstname VARCHAR (255) NOT NULL,
    lastname VARCHAR (255) NOT NULL,
    clean_fn VARCHAR (255) NOT NULL,
    clean_ln VARCHAR (255) NOT NULL,
    phonenumber VARCHAR (30) NOT NULL,
    email VARCHAR(254),
    address VARCHAR (255) NOT NULL,
    postalcode INT NOT NULL,
    note TEXT) ENGINE=InnoDB;
 
CREATE TABLE orders (
    order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    time_of_order timestamp NOT NULL,
    status VARCHAR(255)) ENGINE=InnoDB;
 
CREATE TABLE dish (
    dish_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dishname VARCHAR (255) NOT NULL UNIQUE,
    price DOUBLE NOT NULL,
    cost DOUBLE NOT NULL) ENGINE=InnoDB;

CREATE TABLE categories (
    cat_id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    catname VARCHAR (255)) ENGINE=InnoDB;

CREATE TABLE cat_dish (
    cat_id INT NOT NULL,
    dish_id INT NOT NULL,
    CONSTRAINT cat_dish PRIMARY KEY (cat_id, dish_id)) ENGINE=InnoDB;
    
CREATE TABLE order_dish (
    order_id INT NOT NULL,
    dish_id INT NOT NULL,
    CONSTRAINT order_dish_pk PRIMARY KEY (order_id, dish_id)) ENGINE=InnoDB;

CREATE TABLE postalcode (
    postalcode int PRIMARY KEY,
    place VARCHAR (255)) ENGINE=InnoDB;

CREATE TABLE employee_types (
    employee_id INT NOT NULL,
    type_id INT NOT NULL,
    CONSTRAINT order_dish_pk PRIMARY KEY (employee_id, type_id)) ENGINE=InnoDB;

CREATE TABLE ingredient (
    ingredient_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ingredientname VARCHAR (255)) ENGINE=InnoDB;

CREATE TABLE dish_ingredient (
    dish_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    CONSTRAINT dish_ingredient_pk PRIMARY KEY (dish_id, ingredient_id)) ENGINE=InnoDB;
    

ALTER TABLE orders
    ADD CONSTRAINT orders_fk1 FOREIGN KEY(employee_id) REFERENCES employee (employee_id);

ALTER TABLE orders
    ADD CONSTRAINT orders_fk2 FOREIGN KEY(customer_id) REFERENCES customer (customer_id);

ALTER TABLE order_dish
    ADD CONSTRAINT order_dish_fk1 FOREIGN KEY(order_id) REFERENCES orders (order_id);

ALTER TABLE order_dish
    ADD CONSTRAINT order_dish_fk2 FOREIGN KEY(dish_id) REFERENCES dish (dish_id);

ALTER TABLE employee_types
    ADD CONSTRAINT employee_types_fk1 FOREIGN KEY (employee_id) REFERENCES employee (employee_id);

ALTER TABLE employee_types
    ADD CONSTRAINT employee_types_fk2 FOREIGN KEY (type_id) REFERENCES types (type_id);

ALTER TABLE customer
    ADD CONSTRAINT customer_fk1 FOREIGN KEY (corporatenumber) REFERENCES corporate_register (corporatenumber);

ALTER TABLE employee
    ADD CONSTRAINT employee_fk2 FOREIGN KEY (postalcode) REFERENCES postalcode (postalcode);

ALTER TABLE customer
    ADD CONSTRAINT customer_fk2 FOREIGN KEY (postalcode) REFERENCES postalcode (postalcode);

ALTER TABLE cat_dish
    ADD CONSTRAINT cat_dish_fk1 FOREIGN KEY (cat_id) REFERENCES categories (cat_id);

ALTER TABLE cat_dish
    ADD CONSTRAINT cat_dish_fk2 FOREIGN KEY (dish_id) REFERENCES dish (dish_id);

ALTER TABLE dish_ingredient
    ADD CONSTRAINT dish_ingredient_fk1 FOREIGN KEY (dish_id) REFERENCES dish (dish_id);

ALTER TABLE dish_ingredient
    ADD CONSTRAINT dish_ingredient_fk2 FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id);


INSERT INTO types (name) VALUES ('Admin');
INSERT INTO types (name) VALUES ('Salesperson');
INSERT INTO types (name) VALUES ('Chef');
INSERT INTO types (name) VALUES ('Driver');

INSERT INTO customer (firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES('Jørgen Lien', 'Sellæg', 'JØRGEN LIEN', 'SELLÆG', '93478353', 'jorgen@guut.org', 'Asylveita 3', 7012, 'He has been a customer for years. VIP');
INSERT INTO customer (firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES('Geir Morten', 'Larsen', 'GEIR MORTEN', 'LARSEN', '94883883', 'geir@guut.org', 'Tynset 3', 2500, null );
INSERT INTO customer (firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES('Ted Johan', 'Kristoffersen', 'TED JOHAN', 'KRISTOFFERSEN', '23425554', null, 'Flatåsveien', 7099, null );
INSERT INTO customer (corporatenumber,firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES(659742358,'Bill', 'Gates', 'BILL', 'GATES', '69844656', null, 'Flatåsveien', 7099, null );
INSERT INTO customer (corporatenumber,firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES(698534157,'Oracle', 'Guru', 'ORACLE', 'GURU', '6359841', null, 'Flatåsveien', 7099, null );
INSERT INTO customer (corporatenumber,firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES(458713549,'Arm', 'Chip', 'ARM', 'CHIP', '6548422', null, 'Flatåsveien', 7099, null );

INSERT INTO employee (firstname, lastname, clean_fn, clean_ln, password, phonenumber, postalcode, dob, email) VALUES ('Kjell Toft', 'Hansen', 'KJELL TOFT', 'HANSEN', '900150983cd24fb0d6963f7d28e17f72', '99339933', 7657, '19021992', 'kjellha@procatering.org');
INSERT INTO employee (firstname, lastname, clean_fn, clean_ln, password, phonenumber, postalcode, dob, email) VALUES ('Grethe', 'Sandstrak', 'GRETHE', 'SANDSTRAK', '900150983cd24fb0d6963f7d28e17f72', '99339933', 7657, '19011992', 'grethesa@procatering.org');
INSERT INTO employee (firstname, lastname, clean_fn, clean_ln, password, phonenumber, postalcode, dob, email) VALUES ('Geir', 'Maribu', 'GEIR', 'MARIBU', '900150983cd24fb0d6963f7d28e17f72', '99339933', 7657, '19011992', 'gremlin@procatering.org');

INSERT INTO categories (catname) VALUES ('Take Away');
INSERT INTO categories (catname) VALUES ('Fish');
INSERT INTO categories (catname) VALUES ('Meat');
INSERT INTO categories (catname) VALUES ('Ghost');
INSERT INTO categories (catname) VALUES ('Raw');

INSERT INTO dish (dishname, price, cost) VALUES ('Busters', 1337, 1);
INSERT INTO dish (dishname, price, cost) VALUES ('Pizza Italia', 156, 50);
INSERT INTO dish (dishname, price, cost) VALUES ('Mammoth', 666, 600);
INSERT INTO dish (dishname, price, cost) VALUES ('Salmon', 1337, 1);

INSERT INTO cat_dish (cat_id, dish_id) VALUES (1,2);
INSERT INTO cat_dish (cat_id, dish_id) VALUES (2,4);
INSERT INTO cat_dish (cat_id, dish_id) VALUES (5,4);
INSERT INTO cat_dish (cat_id, dish_id) VALUES (3,3);
INSERT INTO cat_dish (cat_id, dish_id) VALUES (4,1);

INSERT INTO employee_types(employee_id, type_id) VALUES (4,1);
INSERT INTO employee_types(employee_id, type_id) VALUES (4,2);
INSERT INTO employee_types(employee_id, type_id) VALUES (4,3);
INSERT INTO employee_types(employee_id, type_id) VALUES (4,4);
INSERT INTO employee_types(employee_id, type_id) VALUES (5,2);
INSERT INTO employee_types(employee_id, type_id) VALUES (6,2);
INSERT INTO employee_types(employee_id, type_id) VALUES (6,4);

INSERT INTO orders(employee_id,customer_id,time_of_order, status) VALUES (5,5,CURRENT_TIMESTAMP ,'ACTIVE');
INSERT INTO orders(employee_id,customer_id,time_of_order, status) VALUES (5,5,CURRENT_TIMESTAMP ,'ACTIVE');
INSERT INTO orders(employee_id,customer_id,time_of_order, status) VALUES (5,4,CURRENT_TIMESTAMP ,'ACTIVE');
INSERT INTO orders(employee_id,customer_id,time_of_order, status) VALUES (5,5,CURRENT_TIMESTAMP ,'ACTIVE');
INSERT INTO orders(employee_id,customer_id,time_of_order, status) VALUES (4,6,CURRENT_TIMESTAMP ,'ACTIVE');
INSERT INTO orders(employee_id,customer_id,time_of_order, status) VALUES (6,5,CURRENT_TIMESTAMP ,'ACTIVE');
INSERT INTO orders(employee_id,customer_id,time_of_order, status) VALUES (4,5,CURRENT_TIMESTAMP ,'ACTIVE');

INSERT INTO order_dish(order_id,dish_id) VALUES (1,3);
INSERT INTO order_dish(order_id,dish_id) VALUES (2,1);
INSERT INTO order_dish(order_id,dish_id) VALUES (3,1);
INSERT INTO order_dish(order_id,dish_id) VALUES (4,4);
INSERT INTO order_dish(order_id,dish_id) VALUES (5,1);
INSERT INTO order_dish(order_id,dish_id) VALUES (6,1);
INSERT INTO order_dish(order_id,dish_id) VALUES (8,2);

INSERT INTO corporate_register(corporatenumber,corporatename,clean_corporatename) VALUES (698534157, 'Oracle', 'ORACLE');
INSERT INTO corporate_register(corporatenumber,corporatename,clean_corporatename) VALUES (659742358, 'Microsoft', 'MICROSOFT');
INSERT INTO corporate_register(corporatenumber,corporatename,clean_corporatename) VALUES (458713549, 'Arm', 'ARM');

INSERT INTO ingredient(ingredientname) VALUES ('Carrot');
INSERT INTO ingredient(ingredientname) VALUES ('Potato');
INSERT INTO ingredient(ingredientname) VALUES ('Tomato');

INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (1,1);
INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (1,2);
INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (1,3);
INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (4,3);
INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (3,1);
INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (3,3);
INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (4,2);
INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (2,3);
INSERT INTO dish_ingredient(dish_id,ingredient_id) VALUES (2,2);


