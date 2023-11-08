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
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setBounds(0,0,1920,1080);
        this.setPreferredSize(new Dimension(1920,1080));


        // Crea, configura y agrega el PanelExpendedor
        expendedor = new PanelExpendedor(exp);
        expendedor.setBounds(0, 0, 1920, 1080);
        this.add(expendedor);

        // Crea y configura el PanelComprador
        comprador = new PanelComprador();
        comprador.setBounds(1100,100,100,180);


        this.add(comprador);
        for(int i=0;i<5;i++){
            Moneda100 moneda=new Moneda100();
            expendedor.agregarMonedaVuelto(moneda);
        }





        // Agrega el MouseListener
        // este mouse listener incluye toda la ventana, comentado por mientras
        /*
        expendedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                expendedor.handleClick(x, y);
            }
        });
        */
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibuja la máquina expendedora y el comprador
        expendedor.paint(g);

    }
}
