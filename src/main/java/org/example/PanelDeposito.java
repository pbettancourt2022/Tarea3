package org.example;

import javax.swing.*;

class PanelDeposito extends JPanel {
    private int indice;
    private PanelExpendedor expendedor;

    public PanelDeposito(int indice, PanelExpendedor expendedor) {
        this.indice = indice;
        this.expendedor = expendedor;

        // Configura el panel del depósito y sus componentes
    }

    // Otros métodos para gestionar productos o monedas en el depósito
}
