package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelComprador extends JPanel implements MouseListener {
    private int estado; // Variable de estado para controlar la secuencia cíclica
    public PanelComprador(){
        setLayout(new BorderLayout());

        // Crea un nuevo panel para los botones del 0 al 9
        JPanel panelBotones = new JPanel(new GridLayout(5, 2));

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
        panelBotones.setBounds(10, 100, 40, 20);        // Agrega el panel de botones al lado izquierdo del expendedor
        add(panelBotones);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibuja el comprador en función del estado actual
    }

    public void cambiarEstado() {
        // Cambia el estado aquí
    }
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void handleClick() {

    }
}
