package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientService {
    Client registerClient(Integer id, String typeid, String firstname, String secondname, String username, String password) throws SQLException;
    Client findById(Integer id);
    Client findByUserPass(String user, String password) throws SQLException;
    List<Client> listAllClient() throws SQLException;
}
