package com.hacking.libraryapi.services;

import com.hacking.libraryapi.model.Client;
import com.hacking.libraryapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client registerClient(Integer id, String typeid, String firstname, String secondname, String username, String password) throws SQLException {
        Integer idClient = clientRepository.create(id, typeid, firstname, secondname, username, password) ;
        return clientRepository.findById(idClient);
    }

    @Override
    public Client findById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client findByUserPass(String user, String password) throws SQLException {
        return clientRepository.findByUser(user, password);
    }

    @Override
    public List<Client> listAllClient() throws SQLException {
        return clientRepository.listClient();
    }

}
