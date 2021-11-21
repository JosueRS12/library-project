package com.hacking.libraryapi.domain;

public class Cart {
    private Integer id;
    private Integer countProducts;

    public Cart(Integer id, Integer countProducts) {
        this.id = id;
        this.countProducts = countProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountProducts() {
        return countProducts;
    }

    public void setCountProducts(Integer countProducts) {
        this.countProducts = countProducts;
    }
}
