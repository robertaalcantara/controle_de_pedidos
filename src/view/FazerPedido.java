package view;

import model.Cliente;

import javax.swing.*;

public class FazerPedido extends JFrame{
    private JButton clientesButton;
    private JButton pedidosButton;
    private JButton relátoriosButton;
    private JButton produtosButton;
    private JButton balcaoButton;
    private JButton pesquisarButtonProduto;
    private JButton adicionarButtonProduto;
    private JButton finalizarButton;
    private JList list1;
    private JComboBox categoriaComboBox;
    private JTextArea observacaoTextAreaTextArea;
    private JSpinner contadorQuantidade;
    private JComboBox adicionalComboBox;
    private JButton adicionarButton;
    private JButton excluirButton;
    private JList list2;
    private JComboBox formaPagamentoComboBox;
    private JButton crediárioButton;
    private JLabel nomeClienteLabel;
    private JLabel nomeProdutoLabel;
    private JLabel totalPedidoLabel;
    private JPanel mainPanel;
    Cliente cliente = new Cliente();

    public FazerPedido(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

}
