package com.hacking.libraryapi.services;

import com.hacking.libraryapi.repositories.CartBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CartBookServiceImpl implements CartBookService{

    @Autowired
    CartBookRepository cartBookRepository;

    @Override
    public Integer addBook(Integer idBook, Integer idCart, Integer count) throws SQLException {
        return cartBookRepository.addBook(idBook, idCart, count);
    }

    @Override
    public Boolean deleteBook(Integer idBook, Integer idCart) throws SQLException {
        return cartBookRepository.deleteBook(idBook, idCart);
    }

    @Override
    public List<Integer> listIdBooks(Integer idCart) throws SQLException {
        return cartBookRepository.listIdBooks(idCart);
    }
}
