package com.hacking.libraryapi.resources;

import com.hacking.libraryapi.model.Client;
import com.hacking.libraryapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class clientResource {

    @Autowired
    private ClientService clientService;


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, Object> clientMap) throws SQLException {

        Integer id = Integer.valueOf((String) clientMap.get("id"));
        String typeid = (String) clientMap.get("typeid");
        String firstname = (String) clientMap.get("firstname");
        String lastname = (String) clientMap.get("lastname");
        String user = (String) clientMap.get("user");
        String password = (String) clientMap.get("password");
        Client client = clientService.registerClient(id, typeid, firstname, lastname, user, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered succesfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClient(@PathVariable("id") Integer idClient){
        Client client = clientService.findById(idClient);
        return new ResponseEntity<>(client, HttpStatus.FOUND);
    }

    @GetMapping ("")
    public ResponseEntity<List<Client>> listAllClients() throws SQLException {
        List<Client> clients = clientService.listAllClient();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

}
