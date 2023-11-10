package panels;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** Clase principal del proyecto, contiene al resto de paneles e implementa el mouseListener para toda la ventana*/
public class PanelPrincipal extends JPanel {
    /** Instancia de PanelExpendedor*/
    private PanelExpendedor expendedor;
    /** Instancia de PanelComprador*/
    private PanelComprador comprador;

    /** Constructor de la clase, crea los paneles y utiliza el método handleMouseClick para uso del resto de paneles */
    public PanelPrincipal() {
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setBounds(0,0,1920,1080);
        this.setPreferredSize(new Dimension(1920,1080));

        // Crea y agrega los paneles, el orden es importante
        expendedor = new PanelExpendedor();
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
