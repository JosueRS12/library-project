package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Cart;
import com.hacking.libraryapi.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements  CartRepository{
    private static final String SQL_CREATE = "INSERT INTO cart(k_id,k_id_client) VALUES (?,?)";
    private static final String SQL_FIND_BY_ID_CLIENT = "SELECT * FROM cart WHERE k_id_client = ?";
    private static final String SQL_LIST_BOOK = "SELECT book.n_name, cart.v_count_products, book.v_price FROM ((cart_book INNER JOIN cart ON " +
            "cart_book.k_id_cart = cart.k_id AND cart_book.k_id_cart = (?))INNER JOIN book " +
            "ON cart_book.k_id_book = book.k_id)";


    @Autowired
    JdbcTemplate db;

    private RowMapper<Cart> cartRowMapper = ((rs, rowNum)->{
        Cart cart = new Cart();
        cart.setId(rs.getInt("k_id"));
        cart.setIdClient(rs.getInt("k_id_client"));
        cart.setCountProducts(rs.getInt("v_count_products"));
        return cart;
    });
    private RowMapper<Map<String, Object>> prodRowMapper = ((rs, rowNum)->{
        Map<String, Object> map = new HashMap<>();
        map.put("name",rs.getString("n_name"));
        map.put("count",rs.getInt("v_count_products")); //revisar...
        map.put("price",rs.getInt("v_price"));
        return map;
    });

    @Override
    public Integer create(Integer idCart, Integer idClient) throws SQLException {
        try{
            db.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
                ps.setInt(1, idCart);
                ps.setInt(2, idClient);
                return ps;
            });
            return idCart;
        }catch (Exception e){
            throw new SQLException("Error creating cart"+ e.getMessage());
        }
    }

    @Override
    public Cart findByIdClient(Integer id) {
        return db.queryForObject(SQL_FIND_BY_ID_CLIENT, new Object[]{id}, cartRowMapper);
    }

    @Override
    public List<Map<String, Object>> listBooks(Integer CBIdCart) throws SQLException {
        try{
            return db.query(SQL_LIST_BOOK, new Object[]{CBIdCart}, prodRowMapper);
        } catch (Exception e){
            throw new SQLException("Error listing products" + e.getMessage());
        }
    }
}
