package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Book;
import com.hacking.libraryapi.model.Catalogue;

import java.sql.SQLException;
import java.util.List;

public interface CatalogueRepository {
    Integer createCatalogue(Integer id, String name) throws SQLException;
    Catalogue findById(Integer id) throws SQLException;
    List<Book> obtainBooks(Integer idCategory) throws SQLException;
}
