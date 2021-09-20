package view;

import dao.RelatoriosDao;
import model.Caixa;
import model.ConsultasRelatorio;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Relatorios extends JFrame{
    private JButton consulta1Button;
    private JButton consulta3Button;
    private JButton consulta2Button;
    private JList list1;
    private JButton clientesButton;
    private JButton pedidosButton;
    private JButton relatoriosButton;
    private JButton produtosButton;
    private JButton balcaoButton;
    private JPanel mainPanel;
    private JButton crediarioButton;
    RelatoriosDao daoRelatorios = new RelatoriosDao();

    public Relatorios(String title) {
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
        consulta1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<ConsultasRelatorio> lista = daoRelatorios.consulta1();
            }
        });
        consulta2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Caixa caixa = daoRelatorios.consulta2();
            }
        });
        consulta3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<ConsultasRelatorio> lista = daoRelatorios.consulta3();
            }
        });

    }
}
