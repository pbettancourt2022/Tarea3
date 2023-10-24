package org.example;
/** Clase que hereda las propiedades de Producto a través de Bebida*/
class CocaCola extends Bebida {
    /** Constructor de CocaCola, usando el
     * @param numSerie incializa la variable serie heredada de la superclase
     */
    public CocaCola(int numSerie) {
        super(numSerie);
    }

    /** Método que tiene el fin de dar a conocer qué tipo de Producto se ha consumido
     * Además ocupa @Override para asegurarse de que se esté sobreescribiendo en la superclase
     * @return retorna el nombre del producto en minúsculas
     */
    @Override
    public String consumir() {
        return "cocacola";
    }
    /** Getter de tipo*/
    @Override
    public String getTipo() {
        return "CocaCola";
    }
}
