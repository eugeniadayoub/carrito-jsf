package com.ejemplo.model;

public class CartProduct {
    private int id;
    private String nombre;
    private int cantidad;

    public CartProduct() {}

    public CartProduct(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = 1;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
