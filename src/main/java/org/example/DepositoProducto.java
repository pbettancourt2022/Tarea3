package org.example;

import java.util.ArrayList;

public class DepositoProducto {
    private ArrayList<Producto> almacen;

    public DepositoProducto() {
        this.almacen = new ArrayList<>();
    }

    public void addProducto(Producto producto) {
        almacen.add(producto);
    }

    public Producto getProducto() {
        if (!almacen.isEmpty()) {
            return almacen.remove(0);
        } else {
            return null;
        }
    }
}
