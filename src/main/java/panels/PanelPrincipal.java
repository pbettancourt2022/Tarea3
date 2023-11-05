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
        //los tres this de abajo los agregue para hacer funcionar el panel comprador
        this.setLayout(new BorderLayout());
        this.setBounds(100,200,100,150);
        this.setPreferredSize(new Dimension(100,200));


        // Crea y configura el PanelExpendedor
        expendedor = new PanelExpendedor(exp);
        expendedor.setBounds(50, 50, 300, 400);  // Posición y tamaño del expendedor

        // Crea y configura el PanelComprador
//        comprador = new PanelComprador();

        this.add(expendedor);
//        this.add(comprador);
        for(int i=0;i<5;i++){
            Moneda100 moneda=new Moneda100();
            expendedor.agregarMonedaVuelto(moneda);
        }





        // Agrega el MouseListener
        expendedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                expendedor.handleClick(x, y);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibuja la máquina expendedora y el comprador
        expendedor.paint(g);

    }
}
