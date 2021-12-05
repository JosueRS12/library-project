package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.Book;

import java.sql.SQLException;

public interface BookService {
    Book createBook(Integer idBook, Integer idCatalogue, String name, Integer price, Integer count) throws SQLException;
    Integer updateCount(Integer newCount, Integer idBook) throws SQLException;

}
