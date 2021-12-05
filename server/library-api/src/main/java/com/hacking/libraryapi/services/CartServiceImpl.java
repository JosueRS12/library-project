package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.Cart;
import com.hacking.libraryapi.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Override
    public Integer create(Integer idCart, Integer idClient) throws SQLException {
        return cartRepository.create(idCart, idClient);
    }

    @Override
    public Cart findByIdClient(Integer id) {
        return cartRepository.findByIdClient(id);
    }

    @Override
    public List<Map<String, Object>> listBooks(Integer CBIdCart) throws SQLException {
        return cartRepository.listBooks(CBIdCart);
    }
}
