package com.hacking.libraryapi.model;

import java.util.Date;
import java.util.List;

public class Purchase {
    private Integer ref_payment;
    private Integer idCart;
    private Date date;
    private List<String> productos;

    public Integer getRef_payment() {
        return ref_payment;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public void setRef_payment(Integer ref_payment) {
        this.ref_payment = ref_payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }
}
