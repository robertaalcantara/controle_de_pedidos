package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalizarPedido extends JFrame{
    private JPanel mainPanel;
    private JList list1;
    private JButton finalizarButton;
    private JTextField valorPagoTextField;
    private JButton calcularTrocoButton;
    private JButton cancelarButton;
    private JLabel nomeClienteLabel;
    private JLabel valorPedidoLabel;
    private JLabel trocoLabel;


    public FinalizarPedido(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        calcularTrocoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //calcula o troco
            }
        });
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedidos pedidos = new Pedidos("Pedidos");
                pedidos.setVisible(true);
                dispose();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FazerPedido fazerPedido = new FazerPedido("Fazer Pedido");
                fazerPedido.setVisible(true);
                dispose();
            }
        });
    }
}
