package view;

import dao.ClienteDao;
import model.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Clientes extends JFrame{
    private JButton clientesButton;
    private JButton pedidosButton;
    private JButton relatoriosButton;
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
    private JButton crediarioButton;
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
        ClienteDao clienteDao = new ClienteDao();

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
            ArrayList<Cliente> listaClientes = null;
            @Override
            public void actionPerformed(ActionEvent e) {

                if(pesquisarTextField.getText().isEmpty()){
                    listaClientes = clienteDao.listarClientes();
                }else {
                    if (telefoneRadioButton.isSelected()) {
                        listaClientes = clienteDao.listarClientesPorTelefone(pesquisarTextField.getText());
                    }
                    else if(nomeRadioButton.isSelected()){
                        listaClientes = clienteDao.listarClientesPorNome(pesquisarTextField.getText());
                    }
                }
                ///PEGAR A LISTA E MANDAR PRO COMPONENTE VISUAL
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
