package org.example;

import java.util.ArrayList;

/** La siguiente clase tiene el propósito de almacenar los distintos Productos en el proyecto, notar que
 * se ocupa parámetro genérico T para definirla*/
class Deposito<T> {
    /**
     * Esta ArrayList es la que guarda los distintos productos, ocupando un parámetro genérico T
     */
    private ArrayList<T> almacen;

    /** Constructor de la clase, solamente inicializa las variables*/
    public Deposito() {
        this.almacen = new ArrayList<>();
    }

    /**
     * addElemento se usa para agregar un producto a la ArrayList
     * @param elemento es un parámetro genérico, se usa para abarcar todos los productos
     */
    public void addElemento(T elemento) {
        almacen.add(elemento);
    }

    /** Este método tiene el fin de sacar un Producto de la ArrayList
     *
     * @return retorna null si no hay elementos y el mismo elemento en el caso contrario
     */
    public T getElemento() {
        if (!almacen.isEmpty()) {
            return almacen.remove(0);
        } else if (almacen.isEmpty()) {
            return null;
        }
        return null;
    }
}
