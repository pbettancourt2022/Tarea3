package org.example;
/** Subclase de Producto, abarca al resto de dulces*/
abstract class Dulce extends Producto{
    /** Misma funcionalidad que en Producto*/
    private int serie;

    /** Constructor de dulce, utiliza el
     * @param numSerie para inicializar la variable serie
     */
    public Dulce(int numSerie) {
        super(numSerie);
        this.serie = numSerie;
    }
    /** Getter de serie*/
    public int getSerie() {
        return serie;
    }
    /** Clase abstracta, tiene la misma finalidad que en Producto*/
    public abstract String consumir();
    /** Getter de tipo */
    public abstract String getTipo();
}
