package org.example;

import java.util.ArrayList;

public class DepositoProducto {
    private ArrayList<Product> almacen;

    public DepositoProducto() {
        this.almacen = new ArrayList<>();
    }

    public void addProducto(Product producto) {
        almacen.add(producto);
    }

    public Product getProducto() {
        if (!almacen.isEmpty()) {
            return almacen.remove(0);
        } else {
            return null;
        }
    }
}
