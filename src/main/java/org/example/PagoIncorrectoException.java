package org.example;

/** Excepción que tiene el fin de encontrar si se da el caso en que la moneda sea incorrecta*/
class PagoIncorrectoException extends Exception {
    /** Constructor de la excepción, funciona de manera similar a NoHayProductoException
     */
    public PagoIncorrectoException(Moneda m, Deposito monVu) {
        super("El pago es incorrecto.");

    }
}
