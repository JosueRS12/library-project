package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Cart;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CartRepository {
    Integer create(Integer idCart, Integer idClient) throws SQLException;
    Cart findByIdClient(Integer id);
    Boolean updateCountProduct(Integer count, Integer idCart) throws SQLException;
    List<Map<String, Object>> listBooks(Integer CBIdCart) throws SQLException;
}
