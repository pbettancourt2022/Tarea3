package panels;

import org.example.Comprador;
import org.example.Expendedor;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(Expendedor exp, Comprador c){
        super("Máquina Expendedora");
        /**
         * hay que cambiar new BorderLayout() por null para que panel comprador funcione,sin embargo con ese cambio
         * panel expendedor deja de funcionar, vere que puedo arreglar cuando despierte
         */
        setLayout(null);

        PanelPrincipal panelPrincipal = new PanelPrincipal(exp,c);
        add(panelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);

        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());
    }
}
