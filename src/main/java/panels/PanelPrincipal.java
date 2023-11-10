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

    /** Metodo para manejar los clicks en todas las ventanas, manda las coordenadas del click a los otros paneles.
     *
     * @param x coordenada X del click.
     * @param y coordenada Y del click.
     */
    public void handleMouseClick(int x, int y){
        expendedor.handleClick(x, y);
        comprador.handleClick(x, y);
    }

    public PanelExpendedor getExpendedor(){return expendedor;}
    public PanelComprador getComprador(){return comprador;}

}
