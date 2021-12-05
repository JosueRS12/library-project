package com.hacking.libraryapi.resources;

import com.hacking.libraryapi.model.Book;
import com.hacking.libraryapi.model.Catalogue;
import com.hacking.libraryapi.services.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueResource {
    @Autowired
    CatalogueService catalogueService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, Object> bookMap) throws SQLException {

        Integer id = Integer.valueOf((String) bookMap.get("id"));
        String name = (String) bookMap.get("name");
        Catalogue catalogue = catalogueService.createCatalogue(id, name);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered succesfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Book>> listAllBook(@PathVariable("id") Integer id) throws SQLException {
        List<Book> listBooks = catalogueService.listAllBook(id);
        return new ResponseEntity<>(listBooks,HttpStatus.OK);
    }
}
