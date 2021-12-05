package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.Book;
import com.hacking.libraryapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
public class BookServiceImpl implements  BookService{
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Integer idBook, Integer idCatalogue, String name, Integer price, Integer count) throws SQLException {
        Integer idMyBook = bookRepository.createBook(idBook, idCatalogue, name, price, count);
        return bookRepository.findById(idMyBook);
    }

    @Override
    public Integer updateCount(Integer newCount, Integer idBook) throws SQLException {
        return bookRepository.updateCount(newCount, idBook);
    }
}
