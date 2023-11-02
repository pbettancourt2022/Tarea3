package org.example;

import panels.Ventana;

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
        Ventana v = new Ventana(exp);
    }
}

