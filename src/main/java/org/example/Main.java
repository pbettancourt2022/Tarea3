package org.example;

/**
 * Programa que representa la compra de un producto en una máquina expendedora
 * @author Pablo Bettancourt
 * @author Javier Morales
 *
 * @version 0.9 20 de octubre 2023
 */

public class Main {
    public static void main(String[] args) {
        /**
         * Notar que a continuación se representa cómo ocurriría una cierta cantidad de compras con condiciones diferentes
         * Instanciando las clases Moneda, Comprador y Expendedor para ello
         * */
        Expendedor exp = new Expendedor(2);
        Moneda m = null;
        Comprador c = null;
        Moneda moneda;
        /**
         * En este caso se prueba con CocaCola, en la situación que haya suficiente dinero y haya producto
         * También se prueba cuando hay suficiente dinero y no hay producto
         * */
        for (int i = 0; i < 3; i++) {
            moneda = new Moneda1000();
            try {
                m= moneda;
                c = new Comprador(m, Productos.COCACOLA.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        /**
         * En este caso se prueba con Sprite, mismos casos que CocaCola, con la diferencia en que las Bebidas
         * Tienen distinto precio
         */
        for (int i = 0; i < 3; i++) {
            moneda = new Moneda1000();
            try {
                m= moneda;
                c = new Comprador(m, Productos.SPRITE.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        /**
         * En este caso se prueba para Fanta, donde el tipo de Moneda es incorrecto
         */
        for (int i = 0; i < 3; i++) {
            moneda = null;
            try {
                m= moneda;
                c = new Comprador(m, Productos.FANTA.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        /**
         * Se prueba para Snickers, donde se ocupan los mismos casos que para CocaCola
         */
        for (int i = 0; i < 3; i++) {
            moneda = new Moneda1000();
            try {
                m= moneda;
                c = new Comprador(m, Productos.SNICKERS.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        /**
         * Por último se prueba para Super8, donde el pago es insuficiente para llevar a cabo la compra
         */
        for (int i = 0; i < 3; i++) {
            moneda = new Moneda100();
            try {
                m= moneda;
                c = new Comprador(m, Productos.SUPER8.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}



