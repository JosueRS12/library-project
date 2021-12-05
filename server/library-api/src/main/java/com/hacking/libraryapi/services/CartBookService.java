package com.hacking.libraryapi.services;

import java.sql.SQLException;
import java.util.List;

public interface CartBookService {
    Integer addBook(Integer idBook, Integer idCart, Integer count) throws SQLException;
    Boolean deleteBook(Integer idBook, Integer idCart) throws SQLException;
    List<Integer> listIdBooks(Integer idCart) throws SQLException;
}
