package org.example;

/** Representa al expendedor en el escenario, matiene almecenes de los productos, de él se compran los Productos
 * y de él se obtiene el vuelto
 */
public class Expendedor {
    /** todos los Depositos representan a un producto, mientras que el último representa al deposito de monedas de vuelto*/
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito snickers;
    private Deposito super8;
    private Deposito monVu;
    private int numproductos;

    /**
     * Constructor de Expendedor, crea los depositos y llena los de los productos
     * @param numProductos representa la cantidad de productos con la que se llenarán los Depositos
     */
    public Expendedor(int numProductos) {
        coca = new Deposito(); sprite = new Deposito();
        fanta = new Deposito(); snickers = new Deposito();
        super8 = new Deposito(); monVu = new Deposito();
        this.numproductos=numProductos;
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
     *
     * @param m    moneda con la que se compra
     * @param cual producto que se desea
     * @return
     * @throws PagoIncorrectoException
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     */
    public Product comprarProducto(Moneda m, int cual)throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException  {
        Product producto = null;
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
            producto = (Product) temp.getElemento();
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
            producto = (Product) temp.getElemento();
            if (producto == null) {
                int valorMoneda = m.getValor();
                while (valorMoneda != 0) {
                    monVu.addElemento(new Moneda100());
                    valorMoneda -= 100;
                }
            }
        }
        if (producto != null) {
            return null;
        }
        return producto;
    }

    /** Funciona similar a un Getter
     * @return retorna de a una las monedas de 100 dentro de monVu
     */
    public Moneda getVuelto() {
        return (Moneda) monVu.getElemento();
    }
    public Product getProducto(int cualProducto) {
        if (cualProducto == Productos.COCACOLA.getNumero()) {
            return (Product) coca.getElemento();
        } else if (cualProducto == Productos.SPRITE.getNumero()) {
            return (Product) sprite.getElemento();
        } else if (cualProducto == Productos.FANTA.getNumero()) {
            return (Product) fanta.getElemento();
        } else if (cualProducto == Productos.SNICKERS.getNumero()) {
            return (Product) snickers.getElemento();
        } else if (cualProducto == Productos.SUPER8.getNumero()) {
            return (Product) super8.getElemento();
        }
        return null; // Devuelve null si no se encuentra el producto
    }
     public int getNumproductos(){
        return numproductos;
    }

}

