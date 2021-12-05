package com.hacking.libraryapi.resources;

import com.hacking.libraryapi.model.Book;
import com.hacking.libraryapi.model.Catalogue;
import com.hacking.libraryapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookResource {
    @Autowired
    BookService bookService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, Object> bookMap) throws SQLException {

        Integer idBook = Integer.valueOf((String) bookMap.get("idBook"));
        Integer idCatalogue = Integer.valueOf((String) bookMap.get("idCatalogue"));
        String name = (String) bookMap.get("name");
        Integer price = Integer.valueOf((String) bookMap.get("price"));
        Integer count = Integer.valueOf((String) bookMap.get("count"));
        Book book = bookService.createBook(idBook, idCatalogue, name, price, count);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered succesfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PutMapping("/newCount")
    public ResponseEntity<Map<String, String>> updateCount(@RequestBody Map<String, Object> bookMap) throws SQLException {

        Integer count = Integer.valueOf((String) bookMap.get("count"));
        Integer idBook = Integer.valueOf((String) bookMap.get("idBook"));
        bookService.updateCount(count, idBook);
        Map<String, String> map = new HashMap<>();
        map.put("message", "update succesfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
