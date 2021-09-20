package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FazerPedido extends JFrame{
    private JButton clientesButton;
    private JButton pedidosButton;
    private JButton relatoriosButton;
    private JButton produtosButton;
    private JButton balcaoButton;
    private JButton pesquisarButtonProduto;
    private JButton adicionarButtonProduto;
    private JButton finalizarButton;
    private JComboBox categoriaComboBox;
    private JTextArea observacaoTextAreaTextArea;
    private JSpinner contadorQuantidade;
    private JComboBox adicionalComboBox;
    private JButton adicionarButton;
    private JButton excluirButton;
    private JList list2;
    private JComboBox formaPagamentoComboBox;
    private JButton crediarioButton;
    private JLabel nomeClienteLabel;
    private JLabel nomeProdutoLabel;
    private JLabel totalPedidoLabel;
    private JPanel mainPanel;
    private JList list1;
    private JTable table1;
    private JScrollPane scrollPane;
//    Cliente cliente = new Cliente();




    public FazerPedido(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        scrollPane = new JScrollPane();
        String[] Header = {"Nome", "Telefone", "Rua", "Numero", "Complemento", "Bairro", "Frete"};
        list1 = new JList(Header);
        scrollPane.add(list1);
        add(scrollPane);



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
        pesquisarButtonProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //select produto por categoria
            }
        });
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adicionar adicional ao pedido
            }
        });
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinalizarPedido finalizarPedido = new FinalizarPedido("Finalizar Pedido");
                finalizarPedido.setVisible(true);
                dispose();
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete no item selecionado na lista do pedido
            }
        });
        adicionarButtonProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // adicionar produto na lista
            }
        });
    }


}
