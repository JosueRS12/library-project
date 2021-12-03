package com.hacking.libraryapi.repositories;

import com.hacking.libraryapi.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository{

    private static final String SQL_CREATE = "INSERT INTO client(k_id, i_type_id, n_first_name, n_last_name, n_username, n_password) " +
            "VALUES(?,?,?,?,?,?)";
    private static final String SQL_LIST = "SELECT * FROM client";
    private static final String SQL_FIND_CLIENT = "SELECT * FROM client WHERE k_id = ?";

    @Autowired
    JdbcTemplate db;

    private RowMapper<Client> clientRowMapper = ((rs, rowNum)->{
        Client client = new Client();
        client.setId(rs.getInt("k_id"));
        client.setTypeid(rs.getString("i_type_id"));
        client.setFirstName(rs.getString("n_first_name"));
        client.setSecondName(rs.getString("n_last_name"));
        client.setUsername(rs.getString("n_username"));
        client.setPassword(rs.getString("n_password"));
        return client;
    });

    @Override
    public Integer create(Integer id, String typeid, String firstname, String secondname, String username, String password) throws SQLException {
        try{
            db.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
                ps.setInt(1, id);
                ps.setString(2, typeid); //char (2)
                ps.setString(3, firstname);
                ps.setString(4, secondname);
                ps.setString(5, username);
                ps.setString(6, password);
                return ps;
            });
            return id;
        }catch (Exception e){
            throw new SQLException("Error creating client"+ e.getMessage());
        }
    }


    @Override
    public Client findById(Integer id) {
        return db.queryForObject(SQL_FIND_CLIENT, new Object[]{id}, clientRowMapper);
    }



    @Override
    public List<Client> listClient() throws SQLException {
        try{
            return db.query(SQL_LIST, new Object[]{}, clientRowMapper);
        } catch(Exception e){
            throw new SQLException("Error listing all clients" + e.getMessage());
        }
    }
}
