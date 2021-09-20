package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Balcao extends JFrame{
    private JPanel mainPanel;
    private JTextField nomeTextField;
    private JButton continuarButton;
    private JButton cancelarButton;

    public Balcao(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes clientes = new Clientes("Clientes");
                clientes.setVisible(true);
                dispose();
            }
        });
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FazerPedido fazerPedido = new FazerPedido("Fazer Pedido");
                fazerPedido.setVisible(true);
                dispose();
            }
        });
    }




}
