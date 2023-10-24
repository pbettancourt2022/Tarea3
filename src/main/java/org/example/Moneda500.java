package org.example;

/** Representa a una moneda de 500, hereda propiedades de Moneda*/
class Moneda500 extends Moneda implements Comparable<Moneda> {
    /** Constructor de Moneda500, hereda propiedades de Moneda*/
    public Moneda500() {
        super();
    }
    /** Getter del valor
     * @return valor de la moneda expresado
     */
    @Override
    public int getValor() {
        return 500;
    }
    /** toString de la clase */
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = 500}";
    }
    /** Se ocupa para poder implementar la interfaz Comparable*/
    public int compareTo(Moneda500 o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}
