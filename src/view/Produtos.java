package view;

import dao.CategoriaDao;
import dao.ProdutoDao;
import model.Categoria;
import model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Produtos extends JFrame{
    private JPanel mainPanel;
    private JTextField pesquisarNomeTextField;
    private JButton pesquisarButton;
    private JButton clientesButton;
    private JButton relatoriosButton;
    private JButton produtosButton;
    private JButton pedidosButton;
    private JButton balcaoButton;
    private JComboBox categoriaComboBox1;
    private JTextField nomeTextField;
    private JTextField valorTextField;
    private JComboBox categoriaComboBox2;
    private JButton adicionarProdutoButton;
    private JList list1;
    private JButton adicionarCategoriaButton;
    private JButton crediarioButton;
    private JButton excluirButton;
    private JButton excluirCategoriaButton;
    private JButton alterarButton;
    private CategoriaDao daoCategoria = new CategoriaDao();
    private ProdutoDao daoProduto = new ProdutoDao();
    private ArrayList<Categoria> lista = null;

    public Produtos(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        lista = daoCategoria.listarCategorias();
        for(int i=0; i<lista.size(); i++){
            categoriaComboBox2.addItem(lista.get(i).getNome());
            categoriaComboBox1.addItem(lista.get(i).getNome());
        }
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
                Balcao balcao = new Balcao("Balcao");
                balcao.setVisible(true);
                dispose();
            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            ArrayList<Produto> lista = null;
            int codCategoria;
            @Override
            public void actionPerformed(ActionEvent e) {
                codCategoria = daoCategoria.buscarCodCategoria(categoriaComboBox1.getSelectedItem().toString());
                if(pesquisarNomeTextField.getText().isEmpty()){
                    lista = daoProduto.listarProdutosPorCategoria(codCategoria);
                }else {
                    lista = daoProduto.listarProdutosPorCategoriaENome(codCategoria, pesquisarNomeTextField.getText());
                }
                //FALTA PASSAR A LISTA PARA O ELEMENTO VISUAL
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
                Produto produto = new Produto();
                produto.setNome(nomeTextField.getText());
                int codCategoria = daoCategoria.buscarCodCategoria(categoriaComboBox2.getSelectedItem().toString());
                produto.setCodCategoria(codCategoria);
                produto.setPrecoUnitario(Double.parseDouble(valorTextField.getText()));

                daoProduto.inserirProduto(produto);
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        excluirCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codCategoria = daoCategoria.buscarCodCategoria(categoriaComboBox2.getSelectedItem().toString());
                daoCategoria.excluirCategoria(codCategoria);

                lista = daoCategoria.listarCategorias();
                for(int i=0; i<lista.size(); i++){
                    categoriaComboBox2.addItem(lista.get(i).getNome());
                    categoriaComboBox1.addItem(lista.get(i).getNome());
                }
            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //passa informações do produto para a outra tela

            }
        });
    }


}
