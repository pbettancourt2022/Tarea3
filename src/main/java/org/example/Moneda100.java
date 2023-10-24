package org.example;

/** Representa a una moneda de 100, hereda propiedades de Moneda*/
class Moneda100 extends Moneda implements Comparable<Moneda> {
    /** Constructor de Moneda100, hereda propiedades de Moneda*/
    public Moneda100() {
        super();
    }

    /** Getter del valor
     * @return valor de la moneda expresado
     */
    @Override
    public int getValor() {
        return 100;
    }
    /** toString de la clase */
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = 100}";
    }
    /** Se ocupa para poder implementar la interfaz Comparable*/
    public int compareTo(Moneda100 o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}
