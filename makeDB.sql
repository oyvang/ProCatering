CREATE TABLE employee(
    employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	  type_id INT NOT NULL,
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
    corporatenumber INT NOT NULL,
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
    dishname VARCHAR (255) NOT NULL,
    price DOUBLE NOT NULL,
    cost DOUBLE NOT NULL) ENGINE=InnoDB;

CREATE TABLE categories (
    cat_id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dish_id INT NOT NULL,
    catname VARCHAR (255)) ENGINE=InnoDB;
    
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

ALTER TABLE employee
    ADD CONSTRAINT type_fk1 FOREIGN KEY (type_id) REFERENCES types (type_id);

ALTER TABLE customer
    ADD CONSTRAINT customer_fk1 FOREIGN KEY (corporatenumber) REFERENCES corporate_register (corporatenumber);

ALTER TABLE categories
    ADD CONSTRAINT categories_fk1 FOREIGN KEY (dish_id) REFERENCES dish (dish_id);

ALTER TABLE employee
    ADD CONSTRAINT employee_fk2 FOREIGN KEY (postalcode) REFERENCES postalcode (postalcode);

ALTER TABLE customer
    ADD CONSTRAINT customer_fk2 FOREIGN KEY (postalcode) REFERENCES postalcode (postalcode);


INSERT INTO customer (firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES('Jørgen Lien', 'Sellæg', 'JØRGEN LIEN', 'SELLÆG', '93478353', 'jorgen@guut.org', 'Asylveita 3', '7012', 'He has been a customer for years. VIP');
INSERT INTO customer (firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES('Geir Morten', 'Larsen', 'GEIR MORTEN', 'LARSEN', '94883883', 'geir@guut.org', 'Tynset 3', '2500', null );
INSERT INTO customer (firstname, lastname, clean_fn, clean_ln, phonenumber, email, address, postalcode, note) VALUES('Ted Johan', 'Kristoffersen', 'TED JOHAN', 'KRISTOFFERSEN', '23425554', null, 'Flatåsveien', '7099', null );
INSERT INTO employee (firstname, lastname, clean_fn, clean_ln, password, phonenumber, postalcode, dob, email) VALUES ('Kjell Toft', 'Hansen', 'KJELL TOFT', 'HANSEN', '900150983cd24fb0d6963f7d28e17f72', '99339933', 7657, '19021992', 'kjellha@procatering.org');
INSERT INTO employee (firstname, lastname, clean_fn, clean_ln, password, phonenumber, postalcode, dob, email) VALUES ('Grethe', 'Sandstrak', 'GRETHE', 'SANDSTRAK', '900150983cd24fb0d6963f7d28e17f72', '99339933', 7657, '19011992', 'grethesa@procatering.org');
INSERT INTO employee (firstname, lastname, clean_fn, clean_ln, password, phonenumber, postalcode, dob, email) VALUES ('Geir', 'Maribu', 'GEIR', 'MARIBU', '900150983cd24fb0d6963f7d28e17f72', '99339933', 7657, '19011992', 'gremlin@procatering.org');