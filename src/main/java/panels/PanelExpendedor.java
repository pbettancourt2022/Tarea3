package panels;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class PanelExpendedor extends JPanel{
    /** Marca las monedas que entrega de vuelto para pintarlas en el panel */
    private List<Moneda> monedasVuelto;
    /** Marca la moneda a sacar del depósito de monedas */
    private List<Moneda> monedasParaEliminar = new ArrayList<>();
    /** ArrayList que maneja otras ArrayLists de productos, representa los productos que se ven en el expendedor */
    private ArrayList<ArrayList<Product>> productosDisponibles;
    /** Marca el producto a sacar del depósito de productos */
    private List<Product> productosParaEliminar = new ArrayList<>();
    /** Marca el producto que se mueve al depósito de productos */
    private Deposito<Moneda> mDeposito;
    /** Instancia de Expendedor, se usa para crear los productos */
    private Expendedor expendedor;
    /** Coordenada X de destino para el deposito de bebidas */
    private Product productoAMover;
    /** Deposito de monedas en el cual se guardan todas las monedas que se hayan usado en los pagos */
    private int xDestino;
    /** Coordenada Y de destino para el deposito de bebidas */
    private int yDestino;

    /** Constructor de la clase, su funcionalidad es crear "mágicamente" los productos dentro del panel */
    public PanelExpendedor() {
        this.expendedor = new Expendedor(9);
        this.setLayout(new BorderLayout());
        mDeposito = new Deposito<>();
        monedasVuelto = new ArrayList<>();
        productosDisponibles = new ArrayList<>();
        productoAMover = null;

        // Crea arraylists que representan las filas de productos
        ArrayList<Product> depCoca = new ArrayList<>();
        ArrayList<Product> depSprite = new ArrayList<>();
        ArrayList<Product> depFanta = new ArrayList<>();
        ArrayList<Product> depSnickers = new ArrayList<>();
        ArrayList<Product> depSuper8 = new ArrayList<>();
        // Agrega productos a la lista de productos disponibles
        for(int i = 0; i < expendedor.getNumproductos(); i++){
            depCoca.add(new CocaCola(i + 100));
        }
        for(int i = 0; i < expendedor.getNumproductos(); i++){
            depSprite.add(new Sprite(i + 200));
        }
        for(int i = 0; i < expendedor.getNumproductos(); i++){
            depFanta.add(new Fanta(i+300));
        }
        for(int i = 0; i < expendedor.getNumproductos(); i++){
            depSnickers.add(new Snickers(i+400));
        }
        for(int i = 0; i < expendedor.getNumproductos(); i++){
            depSuper8.add(new Super8(i+500));
        }
        productosDisponibles.add(depCoca);
        productosDisponibles.add(depSprite);
        productosDisponibles.add(depFanta);
        productosDisponibles.add(depSnickers);
        productosDisponibles.add(depSuper8);

    }
    /** Método que usamos para agregar monedas a la lista de monedas que se entregarán de vuelto */
    public void agregarMonedaVuelto(Moneda moneda) {
        monedasVuelto.add(moneda);
    }

    /** Método que pinta el PanelExpendedor, lo que lo diferencia del resto es que este también se hace cargo de
     * pintar los productos y las monedas después del pago.
     * @param g the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect(100,570,1200,150);//Suelo
        g.setColor(Color.darkGray);
        g.fillRect(100,20,1200,20);//Techo
        g.setColor(Color.darkGray);
        g.fillRect(100,20,20,700);//Lado izq
        g.setColor(Color.darkGray);
        g.fillRect(900,20,20,700);//Lado cent
        g.setColor(Color.darkGray);
        g.fillRect(1300,20,20,700);//Lado der
        g.setColor(Color.BLACK);
        g.fillRect(1000,620,230,50);//Monedas Vuelto
        g.setColor(Color.BLACK);
        g.fillRect(400,620,230,60);//Producto comprado
        g.setColor(Color.darkGray);
        g.fillRect(100,130,800,10);
        int yBarras=130;
        for(int i = 0; i < 5; i++){
            g.setColor(Color.darkGray);
            g.fillRect(100,yBarras,800,10);
            yBarras=yBarras+110;

        }
        // Dibuja el expendedor y sus componentes (depósitos, productos, monedas, etc.) aquí
        // Dibuja las monedas de vuelto
        int xMoneda = 1000;  // Coordenadas iniciales para las monedas de vuelto
        int yMoneda = 635;
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
        int productosPorFila = expendedor.getNumproductos();
        for (ArrayList<Product> productArrayList : productosDisponibles) {
            for (Product producto : productArrayList) {
                if (!productosParaEliminar.contains(producto) && producto.getSerie() < 200) {
                    g.setColor(Color.red);
                    g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
                    g.setColor(Color.red);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 35, 10, 10);
                    g.setColor(Color.black);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 10, 10, 10);
                    // Calcula las coordenadas del siguiente producto en la fila actual
                    xProducto += 80;
                }
            }
        }

        xProducto = 150;
        yProducto += 110;
        for (ArrayList<Product> productArrayList : productosDisponibles) {
            for (Product producto : productArrayList) {
                if (!productosParaEliminar.contains(producto) && producto.getSerie() < 300 && producto.getSerie() >= 200) {
                    g.setColor(Color.green);
                    g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
                    g.setColor(Color.green);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 35, 10, 10);
                    g.setColor(Color.white);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 10, 10, 10);
                    xProducto += 80;
                }
            }
        }
        xProducto = 150;
        yProducto += 110;
        for (ArrayList<Product> productArrayList : productosDisponibles) {
            for (Product producto : productArrayList) {
                if (!productosParaEliminar.contains(producto) && producto.getSerie() < 400 && producto.getSerie() >= 300) {
                    g.setColor(Color.orange);
                    g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
                    g.setColor(Color.orange);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 35, 10, 10);
                    g.setColor(Color.black);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 10, 10, 10);
                    xProducto += 80;
                }
            }
        }
        xProducto = 150;
        yProducto += 110;
        for (ArrayList<Product> productArrayList : productosDisponibles) {
            for (Product producto : productArrayList) {
                if (!productosParaEliminar.contains(producto) && producto.getSerie() < 500 && producto.getSerie() >= 400) {
                    g.setColor(Color.black);
                    g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
                    g.setColor(Color.black);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 35, 10, 10);
                    g.setColor(Color.white);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 10, 10, 10);
                    xProducto += 80;
                }
            }
        }

        xProducto = 150;
        yProducto += 110;
        for (ArrayList<Product> productArrayList : productosDisponibles) {
            for (Product producto : productArrayList) {
                if (!productosParaEliminar.contains(producto) && producto.getSerie() < 600 && producto.getSerie() >= 500) {
                    g.setColor(Color.BLACK);
                    g.fillRoundRect(xProducto, yProducto, 50, 35, 10, 10); // Ejemplo de un rectángulo redondeado
                    g.setColor(Color.BLACK);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 35, 10, 10);
                    g.setColor(Color.red);
                    g.fillRoundRect(xProducto, (yProducto + 25), 50, 10, 10, 10);
                    xProducto += 80;
                }
            }
        }
        xProducto = 490;
        yProducto += 130;
        if (productoAMover!=null) {
            if ("CocaCola" == productoAMover.getTipo()) {
                // Dibuja el producto en las coordenadas de destino
                g.setColor(Color.red);
                g.fillRoundRect(xProducto, yProducto, 35, 50, 10, 10);
                g.setColor(Color.red);
                g.fillRoundRect((xProducto + 25), (yProducto), 35, 50, 10, 10);
                g.setColor(Color.black);
                g.fillRoundRect((xProducto + 25), (yProducto), 10, 50, 10, 10);
            } else if ("Sprite" == productoAMover.getTipo()) {
                // Dibuja el producto en las coordenadas de destino
                g.setColor(Color.green);
                g.fillRoundRect(xProducto, yProducto, 35, 50, 10, 10);
                g.setColor(Color.green);
                g.fillRoundRect((xProducto + 25), (yProducto), 35, 50, 10, 10);
                g.setColor(Color.white);
                g.fillRoundRect((xProducto + 25), (yProducto), 10, 50, 10, 10);
            } else if ("Fanta" == productoAMover.getTipo()) {
                // Dibuja el producto en las coordenadas de destino
                g.setColor(Color.orange);
                g.fillRoundRect(xProducto, yProducto, 35, 50, 10, 10);
                g.setColor(Color.orange);
                g.fillRoundRect((xProducto + 25), (yProducto), 35, 50, 10, 10);
                g.setColor(Color.black);
                g.fillRoundRect((xProducto + 25), (yProducto), 10, 50, 10, 10);
            } else if ("Snickers" == productoAMover.getTipo()) {
                // Dibuja el producto en las coordenadas de destino
                g.setColor(Color.black);
                g.fillRoundRect(xProducto, yProducto, 35, 50, 10, 10);
                g.setColor(Color.black);
                g.fillRoundRect((xProducto + 25), (yProducto), 35, 50, 10, 10);
                g.setColor(Color.white);
                g.fillRoundRect((xProducto + 25), (yProducto), 10, 50, 10, 10);
            } else if ("Super 8" == productoAMover.getTipo()) {
                // Dibuja el producto en las coordenadas de destino
                g.setColor(Color.black);
                g.fillRoundRect(xProducto, yProducto, 35, 50, 10, 10);
                g.setColor(Color.black);
                g.fillRoundRect((xProducto + 25), (yProducto), 35, 50, 10, 10);
                g.setColor(Color.red);
                g.fillRoundRect((xProducto + 25), (yProducto), 10, 50, 10, 10);
            }
        }


    }

    /** Método que tiene el fin de eliminar monedas y productos de sus respectivos depósitos ocupando
     * las coordenadas del click
     * @param x coordenada X del click
     * @param y coordenada Y del click
     */
    public void handleClick(int x, int y) {
        int i=0;
        for (Moneda moneda : monedasVuelto) {

            if (monedasParaEliminar.contains(moneda)) {
                continue;  // Si ya se debe eliminar, salta al siguiente
            }

            // Calcula las coordenadas donde se encuentra la moneda
            int xMoneda = 1000+ (20*i);
            int yMoneda = 635;

            if (x >= xMoneda && x <= xMoneda + 20 && y >= yMoneda && y <= yMoneda + 20) {
                monedasParaEliminar.add(moneda);
                repaint();

                System.out.println("El valor de la moneda es: $"+moneda.getValor());
                break;
            }
            i++;
        }
        if (x >= 490 && x <= 490 + 50 && y >= 630 && y <= 630 + 40){
            System.out.println("La bebida es: "+productoAMover.getTipo()+" y su numero de serie es: "+productoAMover.getSerie());
            productoAMover=null;
            repaint();
        }
    }

    /** Método que tiene el único propósito de exportar la ubicación de los productos al comprador.
     * @param seleccion integer que ocupamos para seleccionar el producto deseado.
     */
    public void botonCompra(int seleccion){
        if(seleccion == 1) {
            productoAMover = productosDisponibles.get(0).get(0);  // Esto seleccionará el primer producto disponible, adapta según tus necesidades
            productosDisponibles.get(0).remove(0);
        }
        if(seleccion == 2) {
            productoAMover = productosDisponibles.get(1).get(0);  // Esto seleccionará el primer producto disponible, adapta según tus necesidades
            productosDisponibles.get(1).remove(0);
        }
        if(seleccion == 3) {
            productoAMover = productosDisponibles.get(2).get(0);  // Esto seleccionará el primer producto disponible, adapta según tus necesidades
            productosDisponibles.get(2).remove(0);
        }
        if(seleccion == 4) {
            productoAMover = productosDisponibles.get(3).get(0);  // Esto seleccionará el primer producto disponible, adapta según tus necesidades
            productosDisponibles.get(3).remove(0);
        }
        if(seleccion == 5) {
            productoAMover = productosDisponibles.get(4).get(0);  // Esto seleccionará el primer producto disponible, adapta según tus necesidades
            productosDisponibles.get(4).remove(0);
        }
        xDestino = 100;
        yDestino = 100;
        repaint();
    }

    /** Método para calcular el vuelto que se debe entregar en forma de monedas en el expendedor
     * @param faltante integer que representa cuanto se ha pagado del costo del producto, debe ser negativa si entrega vuelto
     */
    public void vuelto(int faltante){
        int temp = -faltante/100;
        for (int i = 0; i < temp; i++) {
            agregarMonedaVuelto(new Moneda100());
        }
        repaint();
    }

    public ArrayList<ArrayList<Product>> getProductosDisponibles(){
        return productosDisponibles;
    }
    public Deposito<Moneda> getMDeposito(){
        return mDeposito;
    }
}
