package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class PanelExpendedor extends JPanel {


    public PanelExpendedor() {
        // Establece un diseño para organizar los elementos
        setLayout(new BorderLayout());

        // Crea un nuevo panel para los botones del 0 al 9
        JPanel panelBotones = new JPanel(new GridLayout(4, 3));

        // Agrega botones del 0 al 9
        for (int i = 0; i <= 9; i++) {
            JButton boton = new JButton(String.valueOf(i));
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Manejar la acción del botón aquí
                }
            });
            panelBotones.add(boton);
        }
        panelBotones.setBounds(10, 100, 400, 200);        // Agrega el panel de botones al lado izquierdo del expendedor
        add(panelBotones);
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
    }

    public void handleClick() {

    }
}
