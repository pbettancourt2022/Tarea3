package org.example;

/** Representa al expendedor en el escenario, matiene almecenes de los productos, de él se compran los Productos
 * y de él se obtiene el vuelto
 */
class Expendedor {
    /** todos los Depositos representan a un producto, mientras que el último representa al deposito de monedas de vuelto*/
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito snickers;
    private Deposito super8;
    private Deposito monVu;

    /**
     * Constructor de Expendedor, crea los depositos y llena los de los productos
     * @param numProductos representa la cantidad de productos con la que se llenarán los Depositos
     */
    public Expendedor(int numProductos) {
        coca = new Deposito(); sprite = new Deposito();
        fanta = new Deposito(); snickers = new Deposito();
        super8 = new Deposito(); monVu = new Deposito();
        for (int i = 0; i < numProductos; i++) {
            coca.addElemento(new CocaCola(i + 100));
            sprite.addElemento(new Sprite(i + 200));
            fanta.addElemento(new Fanta(i+300));
            snickers.addElemento(new Snickers(i+400));
            super8.addElemento(new Super8(i+500));
        }

    }

    /**
     * Método que representa la función de un expendedor, la cual es vender los productos
     * @param m moneda con la que se compra
     * @param cual producto que se desea
     * @return devuelve el producto, o null en el caso de que no hayan o el pago sea inferior al precio
     * @throws PagoIncorrectoException
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     */
    public Producto comprarProducto(Moneda m, int cual)throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException  {
        Producto producto = null;
        Deposito temp = null;
        int precio = 0;
        /**
         * En este if statement se define cual es el producto seleccionado
         */
        if (cual == Productos.COCACOLA.getNumero()) {
            temp = coca;
            precio = Productos.COCACOLA.getPrecio();
        } else if (cual == Productos.SPRITE.getNumero()) {
            temp = sprite;
            precio = Productos.SPRITE.getPrecio();
        } else if (cual == Productos.FANTA.getNumero()) {
            temp = fanta;
            precio = Productos.FANTA.getPrecio();
        } else if (cual == Productos.SNICKERS.getNumero()) {
            temp = snickers;
            precio = Productos.SNICKERS.getPrecio();
        } else if (cual == Productos.SUPER8.getNumero()) {
            temp = super8;
            precio = Productos.SUPER8.getPrecio();
        }
        /** en este if se define el caso en que la moneda sea null*/
        if (m == null) {
            throw new PagoIncorrectoException(m, monVu); // la idea es poner el exception funcional aqui
        } else if (m.getValor() > precio) {
            int valorMoneda = m.getValor();
            int valorVuelto = m.getValor() - precio;
            producto = (Producto) temp.getElemento();
            if (producto == null) { // se deberia agregar en este punto la excepcion de que no hay producto
                throw new NoHayProductoException(m, monVu);
            } else {
                while (valorVuelto != 0) {
                    monVu.addElemento(new Moneda100());
                    valorVuelto -= 100;
                }
            }
        }
        /** en este se define el caso en que el valor de la moneda sea menor al precio*/
        else if (m.getValor() < precio) {
            throw new PagoInsuficienteException(m, monVu); //otro exception a actualizar
        }
        /** en este se define el caso en que el valor de la moneda sea igual al precio*/
        else if (m.getValor() == precio) {
            producto = (Producto) temp.getElemento();
            if (producto == null) {
                int valorMoneda = m.getValor();
                while (valorMoneda != 0) {
                    monVu.addElemento(new Moneda100());
                    valorMoneda -= 100;
                }
            }
        }
        return producto;
    }

    /** Funciona similar a un Getter
     * @return retorna de a una las monedas de 100 dentro de monVu
     */
    public Moneda getVuelto() {
        return (Moneda) monVu.getElemento();
    }
}
