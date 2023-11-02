package panels;

import org.example.Expendedor;
import org.example.Moneda100;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel {
    private PanelExpendedor expendedor;
    private PanelComprador comprador;

    public PanelPrincipal(Expendedor exp) {
        this.setBackground(Color.WHITE);

        // Crea y configura el PanelExpendedor
        expendedor = new PanelExpendedor(exp);
        expendedor.setBounds(50, 50, 300, 400);  // Posición y tamaño del expendedor

        // Crea y configura el PanelComprador
        comprador = new PanelComprador();
        comprador.setBounds(400, 50, 300, 400);  // Posición y tamaño del comprador

        this.add(expendedor);
        this.add(comprador);
        Moneda100 moneda=new Moneda100();
        expendedor.agregarMonedaVuelto(moneda);



        // no veo la necesidad de usar un mouse listener aqui, si ves las instrucciones de la tarea nos dan como tiene que ser
        // el panel principal
        /*
        // Agrega el MouseListener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (expendedor.getBounds().contains(x, y)) {
                    expendedor.handleClick(x, y);  // Redirige el clic al PanelExpendedor
                } else if (comprador.getBounds().contains(x, y)) {
                    comprador.handleClick();  // Redirige el clic al PanelComprador
                }
            }
        })*/
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibuja la máquina expendedora y el comprador
        expendedor.paint(g);
        comprador.paint(g);
    }
}
