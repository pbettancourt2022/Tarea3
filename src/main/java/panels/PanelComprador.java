package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelComprador extends JPanel implements MouseListener {
    private JLabel lPago;
    public PanelComprador(){
        super();
        setBackground(Color.yellow);
        setBounds(920,40,380,530);
        this.setLayout(null);

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

        bMonedas.add(m1);
        bMonedas.add(m2);
        bMonedas.add(m3);

        this.add(bMonedas);

        // Panel con la situacion del pago

        JPanel pPago = new JPanel(new FlowLayout());
        pPago.setBounds(285, 400, 95,80);

        lPago = new JLabel();
        lPago.setText("test");
        lPago.setForeground(Color.GREEN);
        lPago.setBounds(290, 400, 95,90);
        pPago.add(lPago, BorderLayout.CENTER);
        this.add(pPago);
        // Boton para comprar

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void mouseClicked(MouseEvent e){System.out.println("boton presionado");}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

}
