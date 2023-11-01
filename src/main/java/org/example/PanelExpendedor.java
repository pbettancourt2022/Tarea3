package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class PanelExpendedor extends JPanel {
    private List<Moneda> monedasVuelto;
    private List<Moneda> monedasParaEliminar = new ArrayList<>();

    public PanelExpendedor() {
        monedasVuelto = new ArrayList<>();
    }
    public void agregarMonedaVuelto(Moneda moneda) {
        monedasVuelto.add(moneda);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect(100,600,1200,120);//Suelo
        g.setColor(Color.darkGray);
        g.fillRect(100,20,1200,20);//Techo
        g.setColor(Color.darkGray);
        g.fillRect(100,20,20,700);//Lado izq
        g.setColor(Color.darkGray);
        g.fillRect(900,20,20,700);//Lado cent
        g.setColor(Color.darkGray);
        g.fillRect(1300,20,20,700);//Lado der
        g.setColor(Color.BLACK);
        g.fillRect(1000,650,230,50);//Monedas Vuelto
        g.setColor(Color.BLACK);
        g.fillRect(400,650,230,50);//Producto comprado
        // Dibuja el expendedor y sus componentes (depósitos, productos, monedas, etc.) aquí
        // Dibuja las monedas de vuelto
        int xMoneda = 1000;  // Coordenadas iniciales para las monedas de vuelto
        int yMoneda = 660;
        for (Moneda moneda : monedasVuelto) {
            if (!monedasParaEliminar.contains(moneda)) {
                g.setColor(Color.YELLOW);
                g.fillOval(xMoneda, yMoneda, 20, 20);
                xMoneda += 20;
            }
        }
    }
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // Verifica si el clic ocurrió en una moneda de vuelto
        for (Moneda moneda : monedasVuelto) {
            if (monedasParaEliminar.contains(moneda)) {
                continue;  // Si ya se debe eliminar, salta al siguiente
            }

            // Calcula las coordenadas donde se encuentra la moneda
            int xMoneda = 1000 + 25 * monedasVuelto.indexOf(moneda);
            int yMoneda = 660;

            if (x >= xMoneda && x <= xMoneda + 20 && y >= yMoneda && y <= yMoneda + 20) {
                // El clic ocurrió en esta moneda, así que márcala para eliminar
                monedasParaEliminar.add(moneda);
                repaint();  // Vuelve a pintar el panel para que la moneda desaparezca
                break;  // Puedes romper el bucle si ya encontraste la moneda clicada
            }
        }
    }
    public void handleClick(int x, int y) {
        for (Moneda moneda : monedasVuelto) {
            if (monedasParaEliminar.contains(moneda)) {
                continue;  // Si ya se debe eliminar, salta al siguiente
            }

            // Calcula las coordenadas donde se encuentra la moneda
            int xMoneda = 1000 + 25 * monedasVuelto.indexOf(moneda);
            int yMoneda = 660;

            if (x >= xMoneda && x <= xMoneda + 20 && y >= yMoneda && y <= yMoneda + 20) {
                // El clic ocurrió en esta moneda, así que márcala para eliminar
                monedasParaEliminar.add(moneda);
                repaint();  // Vuelve a pintar el panel para que la moneda desaparezca
                break;  // Puedes romper el bucle si ya encontraste la moneda clicada
            }
        }
    }
}
