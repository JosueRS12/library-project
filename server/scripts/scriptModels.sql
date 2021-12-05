-- para crear un cliente
INSERT INTO client VALUES (1193098162,'cc','josue','rodriguez','josuers12','password')
------- Para listar en la pagina de catalogo 
-- insertar un catalogo para harry potter
INSERT INTO catalogue VALUES (123, 'magia');
-- agregar libros a la categoria
INSERT INTO book VALUES (1, 123, 'harry potter y la piedra filosofal', 50000, 2);
INSERT INTO book VALUES (2, 123, 'harry potter y el misterio del principe', 58000, 0);
INSERT INTO book VALUES (3, 123, 'harry potter y el prisionero de azkaban', 45000, 15);
-- listar libros
SELECT book.n_name, book.i_count, book.v_price FROM book, catalogue WHERE book.k_id_catalogue = catalogue.k_id;

-- Para tabla de carrito
-- crear un carrito
INSERT INTO cart VALUES (1234, 4);
DELETE FROM cart Where k_id = 1234;
-- cart_book
INSERT INTO cart_book VALUES (3, 1234);
DELETE FROM cart Where k_id = 1234;
-- private static final String SQL_CREATE = "INSERT INTO client(k_id, i_type_id, n_firts_name, n_last_name, n_username, n_password) " +
            "VALUES(NEXTVAL('client'),?,?,?,?,?,?))";
SELECT book.n_name, cart.v_count_products, book.v_price FROM ((cart_book INNER JOIN cart ON cart_book.k_id_cart = cart.k_id AND cart_book.k_id_cart = 1234)INNER JOIN book ON cart_book.k_id_book = book.k_id);

UPDATE book set i_count = 3 WHERE k_id = 21



