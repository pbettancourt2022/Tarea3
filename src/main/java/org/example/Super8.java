package org.example;
/** Representa a un Super8, hereda sus propiedades de Dulce*/
class Super8 extends Dulce {
    /** Constructor de super8,
     * @param numSerie es utilizado para darle valor a las variables
     */
    public Super8(int numSerie) {
        super(numSerie);
    }
    /** Método que tiene el fin de dar a conocer qué tipo de Producto se ha consumido
     * Además ocupa @Override para asegurarse de que se esté sobreescribiendo en la superclase
     * @return retorna el nombre del producto en minúsculas
     */
    @Override
    public String consumir() {
        return "super 8";
    }
    /** Getter de tipo */
    @Override
    public String getTipo() {
        return "Super 8";
    }
}