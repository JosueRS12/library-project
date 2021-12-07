package com.hacking.libraryapi.resources;

import com.hacking.libraryapi.model.Cart;
import com.hacking.libraryapi.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartResource {

    @Autowired
    CartService cartService;
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> cartMap) throws SQLException {
        Integer idCart = Integer.valueOf((String) cartMap.get("idCart"));
        Integer idClient = Integer.valueOf((String) cartMap.get("idClient"));
        cartService.create(idCart, idClient);
        Map<String, Object> map = new HashMap<>();
        map.put("id", idCart);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Cart> findCartByIdClient(@PathVariable("id") Integer idClient){
        Cart cart = cartService.findByIdClient(idClient);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/{idCart}")
    public ResponseEntity<List<Map<String,Object>>> listAllProducts(@PathVariable("idCart") Integer idCart) throws SQLException {
        List<Map<String, Object>> listProducts = cartService.listBooks(idCart);
        return new ResponseEntity<>(listProducts, HttpStatus.OK);
    }

    @PutMapping("/update-count")
    public ResponseEntity<Map<String, String>> updateCount(@RequestBody Map<String, Object> cartMap) throws SQLException {
        Integer idCart = Integer.valueOf((String) cartMap.get("idCart"));
        Integer count = Integer.valueOf((String) cartMap.get("count"));
        cartService.updateCountProduct(count, idCart);
        Map<String, String> map = new HashMap<>();
        map.put("message", "updating succesfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
