package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BalcaoDelivery extends JFrame{
    private JButton deliveryButton;
    private JButton balcãoButton;
    private JPanel mainPanel;


    public BalcaoDelivery(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        deliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelecaoClienteDelivery selecaoClienteDelivery = new SelecaoClienteDelivery("teste");
                selecaoClienteDelivery.setVisible(true);
                dispose();
            }
        });
        balcãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelecaoClienteBalcao selecaoClienteBalcao = new SelecaoClienteBalcao("teste");
                selecaoClienteBalcao.setVisible(true);
                dispose();
            }
        });
    }


}
