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
        // podríamos cambiar el panel comprador a que tenga tres grids de botones, dos del comprador y una de moneda
        // una del comprador con letras representando las filas y la otra con numeros representando las columnas
        this.setLayout(new GridLayout(9,2));
        for (int i = 0; i <= 9; i++) {
            JButton boton = new JButton(String.valueOf(i));
            boton.setPreferredSize(new Dimension(30,15));
            boton.addMouseListener(this);
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
    public void mouseClicked(MouseEvent e){System.out.println("boton presionado");}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

}
