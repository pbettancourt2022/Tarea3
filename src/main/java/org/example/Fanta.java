package org.example;
/** Hereda las propiedades de Producto a través de Bebida*/
class Fanta extends Bebida {
    /** Constructor de Fanta, utiliza
     * @param numSerie para iniciar el valor de serie, heredado de la superclase
     */
    public Fanta(int numSerie) {
        super(numSerie);
    }

    /** Método que tiene el fin de dar a conocer qué tipo de Producto se ha consumido
     * Además ocupa @Override para asegurarse de que se esté sobreescribiendo en la superclase
     * @return retorna el nombre del producto en minúsculas
     */
    @Override
    public String consumir() {
        return "fanta";
    }
    /** Getter de tipo */
    @Override
    public String getTipo() {
        return "Fanta";
    }
}