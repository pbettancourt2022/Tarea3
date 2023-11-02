package panels;

import org.example.Expendedor;
import org.example.Moneda;
import org.example.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class PanelExpendedor extends JPanel implements MouseListener {
    private List<Moneda> monedasVuelto;
    private List<Moneda> monedasParaEliminar = new ArrayList<>();
    private Expendedor expendedor;

    public PanelExpendedor(Expendedor exp) {
        this.expendedor = exp;
        monedasVuelto = new ArrayList<>();
    }
    public void agregarMonedaVuelto(Moneda moneda) {
        monedasVuelto.add(moneda);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect(100,600,1200,120);//Suelo
        g.setColor(Color.darkGray);
        g.fillRect(100,20,1200,20);//Techo
        g.setColor(Color.darkGray);
        g.fillRect(100,20,20,700);//Lado izq
        g.setColor(Color.darkGray);
        g.fillRect(900,20,20,700);//Lado cent
        g.setColor(Color.darkGray);
        g.fillRect(1300,20,20,700);//Lado der
        g.setColor(Color.BLACK);
        g.fillRect(1000,650,230,50);//Monedas Vuelto
        g.setColor(Color.BLACK);
        g.fillRect(400,650,230,50);//Producto comprado
        // Dibuja el expendedor y sus componentes (depósitos, productos, monedas, etc.) aquí
        // Dibuja las monedas de vuelto
        int xMoneda = 1000;  // Coordenadas iniciales para las monedas de vuelto
        int yMoneda = 660;
        for (Moneda moneda : monedasVuelto) {
            if (!monedasParaEliminar.contains(moneda)) {
                g.setColor(Color.YELLOW);
                g.fillOval(xMoneda, yMoneda, 20, 20);
                xMoneda += 20;
            }
        }
        // Dibuja los productos en filas y columnas
        int xProducto = 150;
        int yProducto = 60;
        int productosPorFila = expendedor.setNumproductos();


        for (int i = 0; i < productosPorFila; i++) {
            Product producto = expendedor.getProducto(i);

            // Dibuja el producto en la posición actual (xProducto, yProducto)
            // Puedes personalizar cómo se muestra el producto aquí
            g.setColor(Color.red);
            g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
            g.setColor(Color.red);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 35, 10, 10);
            g.setColor(Color.black);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 10, 10, 10);
            // Calcula las coordenadas del siguiente producto en la fila actual
            xProducto += 80;

        }
        xProducto = 150;
        yProducto += 110;
        for(int i = 0; i < productosPorFila; i++) {
            Product producto = expendedor.getProducto(i);

            // Dibuja el producto en la posición actual (xProducto, yProducto)
            // Puedes personalizar cómo se muestra el producto aquí
            g.setColor(Color.green);
            g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
            g.setColor(Color.green);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 35, 10, 10);
            g.setColor(Color.white);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 10, 10, 10);
            xProducto += 80;
        }
        xProducto = 150;
        yProducto += 110;
        for(int i = 0; i < productosPorFila; i++) {
            Product producto = expendedor.getProducto(i);

            // Dibuja el producto en la posición actual (xProducto, yProducto)
            // Puedes personalizar cómo se muestra el producto aquí
            g.setColor(Color.orange);
            g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
            g.setColor(Color.orange);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 35, 10, 10);
            g.setColor(Color.black);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 10, 10, 10);
            xProducto += 80;
        }
        xProducto = 150;
        yProducto += 110;
        for(int i = 0; i < productosPorFila; i++) {
            Product producto = expendedor.getProducto(i);

            // Dibuja el producto en la posición actual (xProducto, yProducto)
            // Puedes personalizar cómo se muestra el producto aquí
            g.setColor(Color.BLACK);
            g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
            g.setColor(Color.BLACK);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 35, 10, 10);
            g.setColor(Color.white);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 10, 10, 10);
            xProducto += 80;
        }
        xProducto = 150;
        yProducto += 110;
        for(int i = 0; i < productosPorFila; i++) {
            Product producto = expendedor.getProducto(i);

            // Dibuja el producto en la posición actual (xProducto, yProducto)
            // Puedes personalizar cómo se muestra el producto aquí
            g.setColor(Color.BLACK);
            g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
            g.setColor(Color.BLACK);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 35, 10, 10);
            g.setColor(Color.red);
            g.fillRoundRect(xProducto, (yProducto+25), 50, 10, 10, 10);
            xProducto += 80;
        }

    }
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // Verifica si el clic ocurrió en una moneda de vuelto
        for (Moneda moneda : monedasVuelto) {
            if (monedasParaEliminar.contains(moneda)) {
                continue;  // Si ya se debe eliminar, salta al siguiente
            }

            // Calcula las coordenadas donde se encuentra la moneda
            int xMoneda = 1000 + 25 * monedasVuelto.indexOf(moneda);
            int yMoneda = 660;

            if (x >= xMoneda && x <= xMoneda + 20 && y >= yMoneda && y <= yMoneda + 20) {
                // El clic ocurrió en esta moneda, así que márcala para eliminar
                monedasParaEliminar.add(moneda);
                repaint();  // Vuelve a pintar el panel para que la moneda desaparezca
                break;  // Puedes romper el bucle si ya encontraste la moneda clicada
            }
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void handleClick(int x, int y) {
        for (Moneda moneda : monedasVuelto) {
            if (monedasParaEliminar.contains(moneda)) {
                continue;  // Si ya se debe eliminar, salta al siguiente
            }

            // Calcula las coordenadas donde se encuentra la moneda
            int xMoneda = 1000 + 25 * monedasVuelto.indexOf(moneda);
            int yMoneda = 660;

            if (x >= xMoneda && x <= xMoneda + 20 && y >= yMoneda && y <= yMoneda + 20) {
                // El clic ocurrió en esta moneda, así que márcala para eliminar
                monedasParaEliminar.add(moneda);
                repaint();  // Vuelve a pintar el panel para que la moneda desaparezca
                break;  // Puedes romper el bucle si ya encontraste la moneda clicada
            }
        }
    }
}
