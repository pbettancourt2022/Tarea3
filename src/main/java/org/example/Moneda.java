package org.example;

/** Clase abstracta que representa a una Moneda */
abstract class Moneda implements Comparable<Moneda>{
    /** Constructor de moneda, no tiene ninguna particularidad */
    public Moneda() {}
    /** Getter de serie, ocupa la direccion de memoria como serie */
    public Moneda getSerie() {
        return this;
    }
    /** Getter de valor */
    public abstract int getValor();
    /** toString de la Moneda, es una plantilla más que nada*/
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = " + null + '}';
    }
    /** Necesario para implementar la interfaz Comparable*/
    public int compareTo(Moneda o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}

