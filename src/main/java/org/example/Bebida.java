package org.example;
/** Subclase de Producto, abarca al resto de bebidas */
abstract class Bebida extends Producto{
    /** Misma funcionalidad que en la superclase */
    private int serie;

    /** Constructor de Bebida
     * @param numSerie inicializa serie
     */
    public Bebida(int numSerie) {
        super(numSerie);
        this.serie = numSerie;
    }
    /** Getter de serie */
    public int getSerie() {
        return serie;
    }

    /** Clase abstracta, tiene la misma finalidad que en Producto */
    public abstract String consumir();
    /** Getter de tipo */
    public abstract String getTipo();
}

