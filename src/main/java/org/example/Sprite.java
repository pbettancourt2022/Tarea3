package org.example;
/** Representa la Bebida Sprite, heredando las propiedades de la superclase*/
class Sprite extends Bebida {
    /** Constructor de Sprite, utiliza
     * @param numSerie para iniciar las variables
     */
    public Sprite(int numSerie) {
        super(numSerie);
    }
    /** Método que tiene el fin de dar a conocer qué tipo de Producto se ha consumido
     * Además ocupa @Override para asegurarse de que se esté sobreescribiendo en la superclase
     * @return retorna el nombre del producto en minúsculas
     */
    @Override
    public String consumir() {
        return "sprite";
    }
    /** Getter de tipo */
    @Override
    public String getTipo() {
        return "Sprite";
    }
}
