package com.hacking.libraryapi.model;

import java.util.Date;
import java.util.List;

public class Purchase {
    private Integer ref_payment;
    private Integer idClient;
    private Date date;
    private List<String> productos;

    public Purchase(Integer ref_payment, Integer idClient, Date date, List<String> productos) {
        this.ref_payment = ref_payment;
        this.idClient = idClient;
        this.date = date;
        this.productos = productos;
    }

    public Integer getRef_payment() {
        return ref_payment;
    }

    public void setRef_payment(Integer ref_payment) {
        this.ref_payment = ref_payment;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
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
