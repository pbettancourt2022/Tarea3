package org.example;
/** Enumeración de los Productos dentro del proyecto, contiene su valor y su precio*/
enum Productos {
    COCACOLA(1, 500),
    SPRITE(2, 600),
    FANTA(3, 600),
    SNICKERS(4, 800),
    SUPER8(5, 500);
    /** Representan, respectivamente, al numero con el cual se escoge el producto y el precio del mismo */
    private int numero; private int precio;

    /** Constructor de Productos
     * @param numero representa a la variable numero
     * @param precio representa a la variable precio
     */
    Productos(int numero, int precio){
        this.numero = numero;
        this.precio = precio;
    }
    /** Getter de numero */
    public int getNumero(){return this.numero;}
    /** Getter de precio */
    public int getPrecio(){return this.precio;}

    /** Un toString típico
     * @return retorna de forma ordenada todos los valores dentro de la enumeración
     */
    public String toString(){
        return "Productos{" +
                "COCACOLA: numero = " + COCACOLA.numero + ", precio = " + COCACOLA.precio +
                "SPRITE: numero = " + SPRITE.numero + ", precio = " + SPRITE.precio +
                "FANTA: numero = " + FANTA.numero + ", precio = " + FANTA.precio +
                "SNICKERS: numero = " + SNICKERS.numero + ", precio = " + SNICKERS.precio +
                "SUPER8: numero = " + SUPER8.numero + ", precio = " + SUPER8.precio + '}';
    }
}

