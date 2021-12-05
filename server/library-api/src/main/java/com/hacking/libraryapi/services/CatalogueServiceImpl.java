package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.Book;
import com.hacking.libraryapi.model.Catalogue;
import com.hacking.libraryapi.repositories.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService{

    @Autowired
    CatalogueRepository catalogueRepository;

    @Override
    public Catalogue createCatalogue(Integer id, String name) throws SQLException {
        Integer idCatalogue = catalogueRepository.createCatalogue(id,name);
        return catalogueRepository.findById(idCatalogue);
    }

    @Override
    public List<Book> listAllBook(Integer idCategory) throws SQLException {
        return catalogueRepository.obtainBooks(idCategory);
    }
}
