/* Drop Tables */
DROP TABLE IF EXISTS Client CASCADE;

DROP TABLE IF EXISTS Purchase CASCADE;

DROP TABLE IF EXISTS Cart CASCADE;

DROP TABLE IF EXISTS Cart_Book CASCADE;

DROP TABLE IF EXISTS Book CASCADE;

DROP TABLE IF EXISTS Catalogue CASCADE;

/* Create Tables */

CREATE TABLE Client
(
  k_id integer NOT NULL,
  i_type_id char(2) NOT NULL,
  n_first_name varchar(25) NOT NULL,
  n_last_name varchar(25) NOT NULL,
  n_username varchar(20),
  n_password varchar(20),
  UNIQUE(k_id, n_username, n_password)
);

CREATE TABLE Purchase 
(
  k_ref_payment integer NOT NULL,
  k_id_client integer NOT NULL,
  d_date date NOT NULL,
  v_total_value integer NOT NULL,
  n_products text[] NOT NULL,
  UNIQUE(k_ref_payment)
);

CREATE TABLE Cart 
(
  k_id integer NOT NULL,
  v_count_products integer NOT NULL,
  UNIQUE(k_id)
);

CREATE TABLE Cart_Book 
(
  k_id_book integer NOT NULL,
  k_id_cart integer NOT NULL
);

CREATE TABLE Book 
(
  k_id integer NOT NULL,
  k_id_catalogue integer NOT NULL,
  v_price integer NOT NULL,
  UNIQUE(k_id)
);

CREATE TABLE Catalogue 
(
  k_id integer NOT NULL,
  n_name integer NOT NULL,
  UNIQUE(k_id)
);

/* create primary key*/

ALTER TABLE Client ADD CONSTRAINT PK_Client PRIMARY KEY (k_id);

ALTER TABLE Purchase ADD CONSTRAINT PK_Purchase PRIMARY KEY (k_ref_payment);

CREATE INDEX IXFK_Purchase_Client ON Purchase (k_id_client ASC);

ALTER TABLE Cart ADD CONSTRAINT PK_Cart PRIMARY KEY (k_id);

ALTER TABLE Cart_Book ADD CONSTRAINT PK_Cart_Book PRIMARY KEY (k_id_book, k_id_cart);

CREATE INDEX IXFK_Cart_Book_Book ON Cart_Book (k_id_book ASC);

CREATE INDEX IXFK_Cart_Book_Cart ON Cart_Book (k_id_cart ASC);

ALTER TABLE Book ADD CONSTRAINT PK_Book PRIMARY KEY (k_id);

CREATE INDEX IXFK_Book_Catalogue ON Book (k_id_catalogue ASC);

ALTER TABLE Catalogue ADD CONSTRAINT PK_Catalogue PRIMARY KEY (k_id);

/* Create Foreign Key */
ALTER TABLE Purchase ADD CONSTRAINT FK_Purchase_Client
	FOREIGN KEY (k_id_Client) REFERENCES Client (k_id) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Cart_Book ADD CONSTRAINT IXFK_Cart_Book_Book
	FOREIGN KEY (k_id_book) REFERENCES Book (k_id) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Cart_Book ADD CONSTRAINT IXFK_Cart_Book_Cart
	FOREIGN KEY (k_id_cart) REFERENCES Cart (k_id) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Book ADD CONSTRAINT IXFK_Book_Catalogue
	FOREIGN KEY (k_id_catalogue) REFERENCES Catalogue (k_id) ON DELETE No Action ON UPDATE No Action
;
