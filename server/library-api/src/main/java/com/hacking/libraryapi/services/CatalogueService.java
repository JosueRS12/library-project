package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.Book;
import com.hacking.libraryapi.model.Catalogue;

import java.sql.SQLException;
import java.util.List;

public interface CatalogueService {
    Catalogue createCatalogue(Integer id, String name) throws SQLException;
    List<Book> listAllBook(Integer idCategory) throws SQLException;

}
