package panels;
import org.example.Moneda100;
import org.example.Moneda1000;
import org.example.Moneda500;
import org.example.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelComprador extends JPanel {
    /** Int que se usa para seleccionar el producto */
    private int seleccion;
    /** Int que otorga el pago restante en la transacción */
    private int faltante;
    /** JLabel con el fin de dar a conocer el estado de la transacción */
    private JLabel lPago1;
    /** Jlabel que presenta cuanto falta por pagar*/
    private JLabel lPago2;
    /** Instancia del PanelExpendedor usado en el proyecto, la utilizamos para acceder a las variables dento del expendedor */
    private PanelExpendedor expendedor;

    /** Constructor de la clase, crea todos los botones ocupados en el proyecto para la compra; implementa el método
     * de pago y la selección de producto.
     * @param expendedor instancia de PanelExpendedor, se usa para manipular los productos dentro de este
     */
    public PanelComprador(PanelExpendedor expendedor){
        super();
        this.expendedor = expendedor;
        setBounds(920,40,380,530);
        this.setLayout(null);

        // Panel con la situacion del pago
        JPanel pPago = new JPanel(new FlowLayout());
        pPago.setBounds(285, 400, 95,80);

        lPago1 = new JLabel();
        lPago1.setText(null);
        lPago1.setForeground(Color.GREEN);
        lPago1.setBounds(290, 400, 95,90);
        lPago2 = new JLabel();
        lPago2.setText(null);
        lPago2.setForeground(Color.RED);
        lPago2.setBounds(290,420,95,90);


        pPago.add(lPago1, BorderLayout.NORTH);
        pPago.add(lPago2, BorderLayout.SOUTH);

        this.add(pPago);

        // Botones de los Productos
        JPanel botones = new JPanel();
        botones.setBounds(0, 0, 380, 400);
        botones.setLayout(new GridLayout(5, 1));

        JButton b1 = new JButton("CocaCola");
        b1.setBounds(0, 0, 380, 60);
        JButton b2 = new JButton("Sprite");
        b2.setBounds(0, 70, 380, 60);
        JButton b3 = new JButton("Fanta");
        b3.setBounds(0, 140, 380, 60);
        JButton b4 = new JButton("Snickers");
        b4.setBounds(0, 210, 380, 60);
        JButton b5 = new JButton("Super8");
        b5.setBounds(0, 280, 380, 60);

        // Acciones de los botones
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = 1;
                lPago1.setText("Pendiente");
                lPago2.setText(String.valueOf(Productos.COCACOLA.getPrecio()));
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = 2;
                lPago1.setText("Pendiente");
                lPago2.setText(String.valueOf(Productos.SPRITE.getPrecio()));
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = 3;
                lPago1.setText("Pendiente");
                lPago2.setText(String.valueOf(Productos.FANTA.getPrecio()));
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = 4;
                lPago1.setText("Pendiente");
                lPago2.setText(String.valueOf(Productos.SNICKERS.getPrecio()));
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = 5;
                lPago1.setText("Pendiente");

                lPago2.setText(String.valueOf(Productos.SPRITE.getPrecio()));
            }
        });

        // Agrega los botones
        botones.add(b1);
        botones.add(b2);
        botones.add(b3);
        botones.add(b4);
        botones.add(b5);
        this.add(botones);

        // Botones de las Monedas
        JPanel bMonedas = new JPanel();
        bMonedas.setBounds(0,400,285,80);
        bMonedas.setLayout(new GridLayout(1,3));

        JButton m1 = new JButton("100");
        m1.setBounds(0,400,95,80);
        JButton m2 = new JButton("500");
        m2.setBounds(95,400,95,80);
        JButton m3 = new JButton("1000");
        m3.setBounds(180,400,95,80);

        // Acciones de los botones
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                faltante = Integer.parseInt((lPago2.getText()));
                if(faltante != 0){
                    faltante -= 100;
                    lPago2.setText(String.valueOf(faltante));
                    expendedor.getMDeposito().addElemento(new Moneda100());
                    if(faltante == 0 && seleccion != 0){
                        lPago1.setText("Pagado");
                        lPago2.setText(null);
                    }
                }
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                faltante = Integer.parseInt((lPago2.getText()));
                if(faltante != 0){
                    faltante -= 500;
                    lPago2.setText(String.valueOf(faltante));
                    expendedor.getMDeposito().addElemento(new Moneda500());
                    if(faltante <= 0 && seleccion != 0){
                        lPago1.setText("Pagado");
                        lPago2.setText(null);
                    }
                }
            }
        });
        m3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                faltante = Integer.parseInt((lPago2.getText()));
                if(faltante != 0){
                    faltante -= 1000;
                    lPago2.setText(String.valueOf(faltante));
                    expendedor.getMDeposito().addElemento(new Moneda1000());
                    if(faltante <= 0 && seleccion != 0){
                        lPago1.setText("Pagado");
                        lPago2.setText(null);
                    }
                }
            }
        });

        bMonedas.add(m1);
        bMonedas.add(m2);
        bMonedas.add(m3);

        this.add(bMonedas);

        // Boton para comprar
        JPanel panelBoton = new JPanel(null);
        panelBoton.setBounds(0,480,380,50);
        JButton botonMoverProducto = new JButton("Comprar");
        botonMoverProducto.setBounds(0,0,380,50);
        panelBoton.add(botonMoverProducto);
        botonMoverProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(faltante <= 0 && seleccion != 0) {
                    expendedor.botonCompra(seleccion);
                    expendedor.vuelto(faltante);
                    PanelComprador.this.repaint();
                    repaint();

                }
                PanelComprador.this.repaint();
                repaint();
            }
        });
        this.add(panelBoton);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    /** Recibe el click desde PanelPrincipal y repinta el panel
     * @param x coordenada x del click
     * @param y coordenada y del click
     */
    public void handleClick(int x, int y){
        repaint();
    }

}
