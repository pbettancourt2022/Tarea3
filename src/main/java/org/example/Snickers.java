package org.example;
/** Clase que representa a un Snickers, hereda sus propiedades de la superclase Dulce */
class Snickers extends Dulce {
    /** Constructor de Snickers, utiliza
     * @param numSerie para darle valor a serie, heredada de la superclase
     */
    public Snickers(int numSerie) {
        super(numSerie);
    }
    /** Método que tiene el fin de dar a conocer qué tipo de Producto se ha consumido
     * Además ocupa @Override para asegurarse de que se esté sobreescribiendo en la superclase
     * @return retorna el nombre del producto en minúsculas
     */
    @Override
    public String consumir() {
        return "snickers";
    }
    /** Getter de tipo */
    @Override
    public String getTipo() {
        return "Snickers";
    }
}