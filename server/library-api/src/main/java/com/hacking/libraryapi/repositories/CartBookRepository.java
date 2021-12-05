package com.hacking.libraryapi.repositories;



import java.sql.SQLException;
import java.util.List;

public interface CartBookRepository {
    Integer addBook(Integer idBook, Integer idCart, Integer count) throws SQLException;
    Boolean deleteBook(Integer idBook, Integer idCart) throws SQLException;
    //CartBook findById(Integer idBook, Integer idCart);
    List<Integer> listIdBooks(Integer idCart) throws SQLException;
}
