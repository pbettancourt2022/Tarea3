package org.example;

/** Representa a una moneda de 1000, hereda propiedades de Moneda*/
class Moneda1000 extends Moneda implements Comparable<Moneda> {
    /** Constructor de Moneda500, hereda propiedades de Moneda*/
    public Moneda1000() {
        super();
    }
    /** Getter del valor
     * @return valor de la moneda expresado
     */
    @Override
    public int getValor() {
        return 1000;
    }
    /** toString de la clase */
    public String toString(){
        return "Moneda{" +
                "serie = " + getClass().getSimpleName() +
                ", valor = 1000}";
    }
    /** Se ocupa para poder implementar la interfaz Comparable*/
    public int compareTo(Moneda1000 o) {
        return Integer.compare(this.getValor(), o.getValor());
    }

}
