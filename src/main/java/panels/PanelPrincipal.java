package panels;

import org.example.Comprador;
import org.example.Expendedor;
import org.example.Moneda;
import org.example.Moneda100;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel {
    private PanelExpendedor expendedor;
    private PanelComprador comprador;

    public PanelPrincipal(Expendedor exp, Comprador c) {
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setBounds(0,0,1920,1080);
        this.setPreferredSize(new Dimension(1920,1080));

        // Crea y agrega los paneles, el orden es importante
        expendedor = new PanelExpendedor(exp);
        comprador = new PanelComprador(expendedor);
        comprador.setPreferredSize(new Dimension(380, 530));
        comprador.setBounds(920, 40, 380, 530);
        expendedor.setBounds(0, 0, 1920, 1080);
        this.add(comprador);
        this.add(expendedor);


        //Se calcula cuantas monedas deben de haber en el vuelto
        int vuel=c.cuantoVuelto()/100;
//        for (int i = 0; i < vuel; i++) {
//            Moneda100 moneda = new Moneda100();
//            expendedor.agregarMonedaVuelto(moneda);
//        }

        // Agrega el MouseListener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                handleMouseClick(x, y);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    public void handleMouseClick(int x, int y){
        expendedor.handleClick(x, y);
        comprador.handleClick(x, y);
    }

    public PanelExpendedor getExpendedor(){return expendedor;}
    public PanelComprador getComprador(){return comprador;}

}
