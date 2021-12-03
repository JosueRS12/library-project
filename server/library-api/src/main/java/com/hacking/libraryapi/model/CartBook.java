package com.hacking.libraryapi.model;

public class CartBook {
    private Integer idBook;
    private Integer idCart;

    public CartBook(Integer idBook, Integer idCart) {
        this.idBook = idBook;
        this.idCart = idCart;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }
}
