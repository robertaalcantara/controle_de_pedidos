package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Produtos extends JFrame{
    private JPanel mainPanel;
    private JTextField pesquisarNomeTextField;
    private JButton pesquisarButton;
    private JButton clientesButton;
    private JButton relatoriosButton;
    private JButton produtosButton;
    private JButton pedidosButton;
    private JButton balcaoButton;
    private JComboBox CategoriaComboBox1;
    private JTextField nomeTextField;
    private JTextField valorTextField;
    private JComboBox categoriaComboBox2;
    private JButton adicionarProdutoButton;
    private JList list1;
    private JButton adicionarCategoriaButton;
    private JButton crediarioButton;
    private JButton excluirButton;
    private JButton excluirCategoriaButton;

    public Produtos(String title){
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
        pedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedidos pedidos = new Pedidos("Pedidos");
                pedidos.setVisible(true);
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
        balcaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelecaoClienteBalcao selecaoClienteBalcao = new SelecaoClienteBalcao("Balcao");
                selecaoClienteBalcao.setVisible(true);
                dispose();
            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //select em produto por nome e categoria
            }
        });
        adicionarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarCategoria adicionarCategoria = new AdicionarCategoria("Adicionar Categoria");
                adicionarCategoria.setVisible(true);
                dispose();
            }
        });
        adicionarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //insert tabela produto
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete produto
            }
        });
        excluirCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete categoria
            }
        });
    }


}
