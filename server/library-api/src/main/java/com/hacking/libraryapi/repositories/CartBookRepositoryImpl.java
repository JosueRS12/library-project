package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.CartBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartBookRepositoryImpl implements  CartBookRepository{

    private static final String SQL_CREATE = "INSERT INTO cart_book(k_id_book, k_id_cart, i_count) VALUES (?,?,?)";
    private static final String SQL_DROP_BOOK = "DELETE FROM cart_book Where k_id_book = ? AND k_id_cart = ?";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM cart_book WHERE k_id_cart = (?)";
    private static final String SQL_DROP = "DELETE FROM cart_book Where k_id_cart = (?)";



    @Autowired
    JdbcTemplate db;

    private RowMapper<CartBook> BookRowMapper = ((rs, rowNum) -> {
        CartBook cb = new CartBook();
        cb.setIdBook(rs.getInt("k_id_book"));
        cb.setIdCart(rs.getInt("k_id_cart"));
        cb.setCount(rs.getInt("i_count"));
        return cb;
    });

    @Override
    public Integer addBook(Integer idBook, Integer idCart, Integer count) throws SQLException {
        try{
            db.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
                ps.setInt(1, idBook);
                ps.setInt(2, idCart);
                ps.setInt(3, count);
                return ps;
            });
            return idCart;
        } catch(Exception e){
            throw new SQLException("Error adding a book to cart "+ e.getMessage());
        }
    }

    @Override
    public List<CartBook> findById(Integer idCart) throws SQLException {
        try{
            return db.query(SQL_FIND_BY_ID, new Object[]{idCart}, BookRowMapper);
        } catch(Exception e){
            throw new SQLException("Error finding book of cart "+ e.getMessage());
        }
    }

    @Override
    public Boolean deleteCartBook(Integer idCart) throws SQLException {
        try{
            db.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_DROP);
                ps.setInt(1, idCart);
                return ps;
            });
            return true;
        } catch(Exception e){
            throw new SQLException("Error dropping cart book"+ e.getMessage());
        }    }

    @Override
    public Boolean deleteBook(Integer idBook, Integer idCart) throws SQLException {
        try{
            db.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_DROP_BOOK);
                ps.setInt(1, idBook);
                ps.setInt(2, idCart);
                return ps;
            });
            return true;
        } catch(Exception e){
            throw new SQLException("Error dropping the book to cart "+ e.getMessage());
        }
    }


}
