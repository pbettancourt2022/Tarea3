package org.example;

import panels.Ventana;
import panels.PanelExpendedor;

/**
 * Programa que representa la compra de un producto en una máquina expendedora
 * @author Pablo Bettancourt
 * @author Javier Morales
 *
 * @version 0.91 02 de noviembre 2023
 */

public class Main {
    public static void main(String[] args) {
        /**
         * Notar que, según las instrucciones de la tarea, lo único necesario en el main es
         * una instancia de Ventana
         * */
        Expendedor exp = new Expendedor(9);
        Moneda m= null;
        Comprador c = null;
        Moneda moneda;
        for (int i = 0; i < 3; i++) {
            moneda = new Moneda1500();
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
        Ventana v = new Ventana(exp,c);

    }
}

