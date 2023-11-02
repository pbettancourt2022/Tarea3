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
        this.setBackground(Color.yellow);
        this.setLayout(new GridLayout(5,2));
        this.setBounds(700, 200, 100,150);
        for (int i = 0; i <= 9; i++) {
            JButton boton = new JButton(String.valueOf(i));
            boton.setPreferredSize(new Dimension(30,15));
            this.add(boton);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void cambiarEstado() {
        // Cambia el estado aquí
    }
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

}
