package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientRepository{
    Integer create(Integer id, String typeid, String firstname, String secondname, String username, String password) throws SQLException;
    Client findById(Integer id);
    Client findByUser(String user, String password) throws SQLException;
    List<Client> listClient() throws SQLException;

}
