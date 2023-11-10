package panels;

import org.example.Comprador;
import org.example.Expendedor;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
/** Clase que crea la ventana en la cual se encuentran los paneles */
public class Ventana extends JFrame {
    /** Constructor de Ventana, simplemente crea la ventana e implementa el panel principal, además agrega un ícono */
    public Ventana(){
        super("Máquina Expendedora");
        setLayout(null);

        PanelPrincipal panelPrincipal = new PanelPrincipal();
        add(panelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);

        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());
    }
}
