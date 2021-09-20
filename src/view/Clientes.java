package view;

import controller.ClienteDeliveryAtual;
import dao.ClienteDao;
import dao.EnderecoDao;
import model.Cliente;
import model.Endereco;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JButton alterarClienteButton;
    private JButton crediarioButton;
    private JButton selecionarClienteParaDeliveryButton;
    private JPanel mainPanel;
    private JTextField freteTextField;
    private JTable table;
    private JScrollPane scrollPane1;

    String Header[]= {"Nome", "Telefone", "Rua", "Numero", "Complemento", "Bairro", "Frete"};

    private void createUIComponents(String nome, String telefone, String rua, int numero, String complemento, String bairro, double frete) {
        // TODO: place custom component creation code here
        DefaultTableModel model = new DefaultTableModel(0,7);
        model.setColumnIdentifiers(Header);
        table = new JTable(model);
        model.addRow(new Object[]{
                nome, telefone, rua, numero, complemento, bairro, frete
        });
    }

    public Clientes(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ClienteDao clienteDao = new ClienteDao();
        EnderecoDao enderecoDao = new EnderecoDao();

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
                for(Cliente c: clienteDao.listarClientes()){
                    Endereco endereco = new Endereco();
                    endereco = enderecoDao.buscarEndereco(c.getCodEndereco());
                    createUIComponents(c.getNome(), c.getTelefone(), endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getFrete());
                }
            }
        });
        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Endereco endereco = new Endereco();
                Cliente cliente = new Cliente();
                int codEndereco, codCliente;

                endereco.setRua(ruaTextField.getText());
                endereco.setBairro(bairroTextField.getText());
                endereco.setNumero(Integer.parseInt(numeroTextField.getText()));
                endereco.setFrete(Double.parseDouble(freteTextField.getText()));
                if(!complementoTextField.getText().isEmpty()){
                    endereco.setComplemento(complementoTextField.getText());
                }

                codEndereco = enderecoDao.buscarCodEndereco(endereco);

                if(codEndereco == 0){
                    enderecoDao.inserirEndereco(endereco);
                    codEndereco = enderecoDao.buscarCodEndereco(endereco);
                }
                endereco.setCodEndereco(codEndereco);

                cliente.setNome(nomeTextField.getText());
                cliente.setTelefone(telefoneTextField.getText());

                codCliente = clienteDao.buscarCodCliente(cliente);

                if(codCliente == 0){
                    cliente.setCodEndereco(codEndereco);
                    clienteDao.inserirCliente(cliente);
                    codCliente = clienteDao.buscarCodCliente(cliente);
                }
                ClienteDeliveryAtual.setClienteAtual(cliente);
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
