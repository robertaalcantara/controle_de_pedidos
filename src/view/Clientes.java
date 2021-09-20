package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clientes extends JFrame{
    private JButton clientesButton;
    private JButton pedidosButton;
    private JButton relátoriosButton;
    private JButton produtosButton;
    private JButton balcaoButton;
    private JTextField pesquisarTextField;
    private JButton pesquisarButton;
    private JRadioButton nomeRadioButton;
    private JRadioButton telefoneRadioButton;
    private JTextField nomeTextField;
    private JTextField telefoneTextField;
    private JTextField ruaTextField;
    private JTextField numeroTextField;
    private JTextField complementoTextField;
    private JTextField bairroTextField;
    private JButton cadastrarClienteButton;
    private JList list1;
    private JButton alterarClienteButton;
    private JButton crediárioButton;
    private JButton selecionarClienteParaDeliveryButton;
    private JPanel mainPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public Clientes(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        crediárioButton.addActionListener(new ActionListener() {
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
        relátoriosButton.addActionListener(new ActionListener() {
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
                SelecaoClienteBalcao selecaoClienteBalcao = new SelecaoClienteBalcao("Balcao");
                selecaoClienteBalcao.setVisible(true);
                dispose();
            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //verificar se é telefone ou nome e fazer select no banco
            }
        });
        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fazer insert no banco
            }
        });
        selecionarClienteParaDeliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mandar nome do cliente para a outra tela
                FazerPedido fazerPedido = new FazerPedido("Fazer Pedido");
                fazerPedido.setVisible(true);
                dispose();
            }
        });
        alterarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mandar informacoes do cliente selecionado para a outra tela
                AlterarCliente alterarCliente = new AlterarCliente("Alterar Cliente");
                alterarCliente.setVisible(true);
                dispose();
            }
        });
    }
}
