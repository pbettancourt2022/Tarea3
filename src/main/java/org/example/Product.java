package org.example;

import java.awt.*;

/**
 * Super clase que abarca todos los productos dentro del proyecto
 */
public abstract class Product {
    /** Integer que tiene el fin de diferenciar el producto del resto de productos similiares */
    private int serie;


    /** Constructor de la clase, solamente le asigna valor a la variable
     * @param numSerie valor a asignar a serie*/
    public Product(int numSerie) {
        this.serie = numSerie;
    }
    /** Getter para serie*/
    public int getSerie() {
        return serie;
    }

    /** Clase abstracta que sirve de base para las subclases de Producto
     * Sirve para luego dar a conocer el sabor del consumible
     * @return no tiene retorno, es abstracta
     */
    public abstract String consumir();
    /** Getter de tipo, la verdad no es necesario, sin embargo estaba en el proyecto de PA3P */
    public abstract String getTipo();
}
