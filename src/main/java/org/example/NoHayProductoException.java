package org.example;

/** Excepción que tiene el fin de encontrar si se da el caso en que no haya un producto en el expendedor */
class NoHayProductoException extends Exception {
    /** Constructor de NoHayProductoException
     * @param m se usa para revisar el caso en que al agregar la moneda no haya producto
     * @param monVu se usa para revisar el caso en que al agregar la moneda no haya producto
     */
    public NoHayProductoException(Moneda m, Deposito monVu) {
        super("No hay productos disponibles en el depósito.");

    }
}


