package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.CartBook;

import java.sql.SQLException;
import java.util.List;

public interface CartBookService {
    Integer addBook(Integer idBook, Integer idCart, Integer count) throws SQLException;
    Boolean deleteBook(Integer idBook, Integer idCart) throws SQLException;
    Boolean deleteCartBook(Integer idCart) throws SQLException;
    List<CartBook> findById(Integer idCart) throws SQLException;
}
