package com.ejemplo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.ejemplo.model.CartProduct;

@ManagedBean(name = "cartBean")
@SessionScoped
public class CartBean implements Serializable {

    private int id;
    private String nombre;
    private List<CartProduct> carrito = new ArrayList<>();

    private CartProduct productoEditando = null;
    private boolean editando = false;

    public void agregarProducto() {
        if (editando && productoEditando != null) {
            productoEditando.setId(id);
            productoEditando.setNombre(nombre);
            productoEditando = null;
            editando = false;
        } else {
            carrito.add(new CartProduct(id, nombre));
        }
        id = 0;
        nombre = "";
    }

    public void eliminarProducto(CartProduct p) {
        carrito.remove(p);
    }

    public void incrementar(CartProduct p) {
        p.setCantidad(p.getCantidad() + 1);
    }

    public void decrementar(CartProduct p) {
        if (p.getCantidad() > 1) {
            p.setCantidad(p.getCantidad() - 1);
        }
    }

    public String editarProducto(CartProduct p) {
        this.productoEditando = p;
        this.id = p.getId();
        this.nombre = p.getNombre();
        this.editando = true;
        return "agregar.xhtml"; 
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<CartProduct> getCarrito() { return carrito; }
    public void setCarrito(List<CartProduct> carrito) { this.carrito = carrito; }

    public boolean isEditando() { return editando; }
}
