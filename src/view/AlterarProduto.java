package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarProduto extends JFrame{
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton salvarButton;
    private JButton cancelarButton;

    public AlterarProduto(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produtos produtos = new Produtos("Produtos");
                produtos.setVisible(true);
                dispose();
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //update em produto
                Produtos produtos = new Produtos("Produtos");
                produtos.setVisible(true);
                dispose();
            }
        });
    }
}
