package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    Integer createBook(Integer idBook, Integer idCatalogue, String name, Integer price, Integer count) throws SQLException;
    Book findById(Integer id) throws SQLException;
    Integer updateCount(Integer newCount, Integer idBook) throws SQLException;
}
