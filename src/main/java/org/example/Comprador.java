package org.example;

/** Representa al comprador en este escenario, compra un producto del expendedor, recibe un vuelto y luego consume
 * el producto, dando el nombre de aquel
 */
class Comprador {
    /** String que almacena el nombre del producto */
    private String sonido;
    /** Integer que almacena el vuelto */
    private int vuelto;

    /** Constructor de Comprador, calcula el vuelto dentro de él, removiendo monedas de monVu en el Expendedor, y también
     * obtiene el nombre del producto.
     * @param m moneda con la que compra
     * @param cualProducto decide el producto que comprará
     * @param exp el expendedor del que comprará
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    public Comprador(Moneda m, int cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        vuelto = 0;
            Producto producto = exp.comprarProducto(m, cualProducto);

            if (producto != null) {
                sonido = producto.consumir();
                while ((m = exp.getVuelto()) != null) {
                    vuelto = vuelto + m.getValor();
                }
            } else {
                sonido = null;
                vuelto= m.getValor();

            }

    }

    /** Funciona como Getter de vuelto
     * @return retorna el valor de vuelto
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /** Funciona como getter de sonido
     * @return retorna el valor de sonido
     */
    public String queBebiste() {
        return sonido;
    }
}
