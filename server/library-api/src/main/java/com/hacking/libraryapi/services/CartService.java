package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.Cart;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CartService {
    Integer create(Integer idCart, Integer idClient) throws SQLException;
    Cart findByIdClient(Integer id);
    List<Map<String, Object>> listBooks(Integer CBIdCart) throws SQLException;
    //drop cart
}
