package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
        Ventana v = new Ventana();


    }
}

