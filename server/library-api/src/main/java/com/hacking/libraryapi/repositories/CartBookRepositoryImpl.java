package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Book;
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
    private static final String SQL_LIST = "SELECT * FROM cart_book WHERE k_id_cart = ?";
    private static final String SQL_DROP_BOOK = "DELETE FROM cart_book Where k_id_book = ? AND k_id_cart = ?";

    @Autowired
    JdbcTemplate db;

    private RowMapper<Integer> idBookRowMapper = ((rs, rowNum) -> {
        Integer id = 0;
        id = rs.getInt("k_id_book");
        return id;
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
    public List<Integer> listIdBooks(Integer idCart) throws SQLException {
        try{
            return db.query(SQL_LIST, new Object[]{idCart}, idBookRowMapper);
        } catch(Exception e){
            throw new SQLException("Error listing books of cart "+ e.getMessage());
        }
    }

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
