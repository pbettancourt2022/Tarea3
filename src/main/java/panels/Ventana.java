package panels;

import org.example.Expendedor;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(Expendedor exp){
        super("Máquina Expendedora");
        setLayout(new BorderLayout());

        PanelPrincipal panelPrincipal = new PanelPrincipal(exp);
        add(panelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);

    }
}
