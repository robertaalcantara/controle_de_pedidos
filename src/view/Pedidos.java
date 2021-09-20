package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pedidos extends JFrame {
    private JButton clientesButton;
    private JButton pedidosButton;
    private JButton relatoriosButton;
    private JButton produtosButton;
    private JButton balcaoButton;
    private JButton pesquisarButton;
    private JTextField nomeClienteTextField;
    private JButton crediarioButton;
    private JPanel mainPanel;
    private JScrollPane scrollPane;

//    String Header[] = {"Numero", "Nome do Cliente", "Produto", "Valor", "Tipo", "Frete"};

    private void createUIComponents() {
        // TODO: place custom component creation code here
//        DefaultTableModel model = new DefaultTableModel(2, 6);
//        model.setColumnIdentifiers(Header);
//        table1 = new JTable(model);
    }

    public Pedidos(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes clientes = new Clientes("Clientes");
                clientes.setVisible(true);
                dispose();
            }
        });
        crediarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Crediario crediario = new Crediario("Crediario");
                crediario.setVisible(true);
                dispose();
            }
        });
        relatoriosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Relatorios relatorios = new Relatorios("Relatorios");
                relatorios.setVisible(true);
                dispose();
            }
        });
        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produtos produtos = new Produtos("Produtos");
                produtos.setVisible(true);
                dispose();
            }
        });
        balcaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Balcao balcao = new Balcao("Balcao");
                balcao.setVisible(true);
                dispose();
            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //select pedido pelo nome
            }
        });
    }
}

