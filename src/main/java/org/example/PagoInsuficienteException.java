package org.example;

/** Excepción que tiene con el fin encontrar si el pago es menor que el costo de la bebida*/
class PagoInsuficienteException extends Exception {
    /** Constructor de la excepción, utiliza la misma lógica de el resto de excepciones en el proyecto*/
    public PagoInsuficienteException(Moneda m, Deposito monVu) {
        super("El pago es insuficiente para comprar el producto.");

    }

}
