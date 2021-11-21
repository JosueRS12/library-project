package com.hacking.libraryapi.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/clients/")
public class clientResource {

    @PostMapping("/register")
    public String registerClient(@RequestBody Map<String, Object> clientMap){
        String firstName = (String) clientMap.get("n_first_name");
        String lastName = (String) clientMap.get("n_last_name");
        String username = (String) clientMap.get("n_username");
        String password = (String) clientMap.get("n_password");
        /*
        Integer id = (Integer) userMap.get("k_id");
        String typeId = (string) userMap.get("k_type_id");
         */
        return firstName + ", "+ lastName+", "+username+", "+ password;
    }
}
