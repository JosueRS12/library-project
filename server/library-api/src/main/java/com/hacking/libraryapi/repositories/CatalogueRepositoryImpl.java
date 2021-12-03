package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Book;
import com.hacking.libraryapi.model.Catalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CatalogueRepositoryImpl implements CatalogueRepository{

    private static final String SQL_CREATE = "INSERT INTO catalogue(k_id, n_name) VALUES (?,?)";
    private static final String SQL_LIST = "SELECT book.n_name, book.i_count, book.v_price FROM book, catalogue " +
            "WHERE book.k_id_catalogue = ?";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM catalogue WHERE k_id = ?";

    private RowMapper<Book> bookRowMapper = ((rs, rowNum) -> {
        Book book = new Book();
        book.setName(rs.getString("n_name"));
        book.setCount(rs.getInt("i_count"));
        book.setPrice(rs.getInt("v_price"));

        return book;
    });

    private RowMapper<Catalogue> catalogueRowMapper = ((rs, rowNum) -> {
        Catalogue catalogue = new Catalogue();
        catalogue.setId(rs.getInt("k_id"));
        catalogue.setName(rs.getString("n_name"));
        return catalogue;
    });

    @Autowired
    JdbcTemplate db;


    @Override
    public Integer createCatalogue(Integer id, String name) throws SQLException {
        try{
            db.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
                ps.setInt(1, id);
                ps.setString(1, name);
                return ps;
            });
            return id;
        } catch(Exception e){
            throw new SQLException("Error creating catalogue "+ e.getMessage());
        }
    }

    @Override
    public Catalogue findById(Integer id) throws SQLException {
        try{
            return (Catalogue) db.query(SQL_FIND_BY_ID, new Object[]{id}, catalogueRowMapper);
        } catch(Exception e){
            throw new SQLException("Error finding catalogue"+ e.getMessage());
        }
    }

    @Override
    public List<Book> obtainBooks(Integer idCategory) throws SQLException {
        try{
            return db.query(SQL_LIST, new Object[]{idCategory}, bookRowMapper);
        } catch(Exception e){
            throw new SQLException("Error listing books of catalogue "+ e.getMessage());
        }
    }
}
