package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Máquina Expendedora");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PanelPrincipal panelPrincipal = new PanelPrincipal();
            frame.add(panelPrincipal);
            frame.pack();
            frame.setVisible(true);
        });

    }
}
class PanelPrincipal extends JPanel {
    private PanelExpendedor expendedor;
    private PanelComprador comprador;
    public PanelPrincipal() {
        this.setSize(800, 600);  // Tamaño del panel principal
        this.setBackground(Color.WHITE);

        // Crea y configura el PanelExpendedor
        expendedor = new PanelExpendedor();
        expendedor.setBounds(50, 50, 300, 400);  // Posición y tamaño del expendedor

        // Crea y configura el PanelComprador
        comprador = new PanelComprador();
        comprador.setBounds(400, 50, 300, 400);  // Posición y tamaño del comprador

        this.add(expendedor);
        this.add(comprador);


        // Agrega el MouseListener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (expendedor.getBounds().contains(x, y)) {
                    expendedor.handleClick();  // Redirige el clic al PanelExpendedor
                } else if (comprador.getBounds().contains(x, y)) {
                    comprador.handleClick();  // Redirige el clic al PanelComprador
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibuja la máquina expendedora y el comprador
        expendedor.paint(g);
        comprador.paint(g);
    }
}
class PanelExpendedor extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibuja el expendedor y sus componentes (depósitos, productos, monedas, etc.) aquí
    }

    public void handleClick() {

    }
}
class PanelComprador extends JPanel {
    private int estado; // Variable de estado para controlar la secuencia cíclica

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibuja el comprador en función del estado actual
    }

    public void cambiarEstado() {
        // Cambia el estado aquí
    }

    public void handleClick() {

    }
}
