package com.hacking.libraryapi.resources;

import com.hacking.libraryapi.services.CartBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/cartbook")
public class CartBookResource {
    @Autowired
    CartBookService cartBookService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> add(@RequestBody Map<String, Object> cbMap) throws SQLException {
        Integer idBook = Integer.valueOf((String) cbMap.get("idBook"));
        Integer idCart = Integer.valueOf((String) cbMap.get("idCart"));
        Integer count = Integer.valueOf((String) cbMap.get("count"));

        cartBookService.addBook(idBook, idCart, count);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered succesfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, String>> listAllBook(@RequestBody Map<String, Object> cbMap) throws SQLException {
        Integer idBook = Integer.valueOf((String) cbMap.get("idBook"));
        Integer idCart = Integer.valueOf((String) cbMap.get("idCart"));
        cartBookService.deleteBook(idBook,idCart);
        Map<String, String> map = new HashMap<>();
        map.put("message", "drop succesfully");
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
