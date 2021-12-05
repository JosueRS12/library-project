package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class BookRepositoryImpl implements  BookRepository{

    private static final String SQL_CREATE = "INSERT INTO book(k_id,k_id_catalogue,n_name,v_price,i_count) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM book WHERE k_id = ?";
    private static final String SQL_UPDATE_COUNT = "UPDATE book set i_count = i_count - (?) WHERE k_id = (?)";


    @Autowired
    JdbcTemplate db;

    private RowMapper<Book> bookRowMapper = ((rs, rowNum) -> {
        Book book = new Book();
        book.setCount(rs.getInt("k_id"));
        book.setPrice(rs.getInt("k_id_catalogue"));
        book.setName(rs.getString("n_name"));
        book.setCount(rs.getInt("i_count"));
        book.setPrice(rs.getInt("v_price"));
        return book;
    });

    @Override
    public Integer createBook(Integer idBook, Integer idCatalogue, String name, Integer price, Integer count) throws SQLException {
        try{
            db.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
                ps.setInt(1, idBook);
                ps.setInt(2, idCatalogue);
                ps.setString(3, name);
                ps.setInt(4, price);
                ps.setInt(5, count);
                return ps;
            });
            return idBook;
        } catch(Exception e){
            throw new SQLException("Error creating book "+ e.getMessage());
        }
    }

    @Override
    public Book findById(Integer id) throws SQLException {
        try{
            return db.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, bookRowMapper);
        } catch(Exception e){
            throw new SQLException("Error finding book"+ e.getMessage());
        }
    }

    @Override
    public Integer updateCount(Integer newCount, Integer idBook) throws SQLException {
        try{
            db.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_COUNT);
                ps.setInt(1, newCount);
                ps.setInt(2, idBook);
                return ps;
            });
            return newCount;
        } catch(Exception e){
            throw new SQLException("Error updating count of book "+ e.getMessage());
        }
    }
}
