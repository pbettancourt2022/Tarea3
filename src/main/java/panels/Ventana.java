package panels;

import org.example.Expendedor;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(Expendedor exp){
        super("Máquina Expendedora");
        /**
         * hay que cambiar new BorderLayout() por null para que panel comprador funcione,sin embargo con ese cambio
         * panel expendedor deja de funcionar, vere que puedo arreglar cuando despierte
         */
        setLayout(new BorderLayout());

        PanelPrincipal panelPrincipal = new PanelPrincipal(exp);
        add(panelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);

        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());
    }
}
