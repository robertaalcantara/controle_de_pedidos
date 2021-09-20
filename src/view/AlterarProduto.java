package view;

import dao.CategoriaDao;
import dao.ProdutoDao;
import model.Categoria;
import model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AlterarProduto extends JFrame{
    private JPanel mainPanel;
    private JTextField nomeTextField;
    private JTextField valorTextField;
    private JComboBox comboBox1;
    private JButton salvarButton;
    private JButton cancelarButton;
    private ArrayList<Categoria> lista = null;
    private CategoriaDao daoCategoria = new CategoriaDao();
    private ProdutoDao daoProduto = new ProdutoDao();
    private int codProdutoAtual;

    public AlterarProduto(String title, Produto produto){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        lista = daoCategoria.listarCategorias();
        for(int i=0; i<lista.size(); i++){
            comboBox1.addItem(lista.get(i).getNome());
        }
        nomeTextField.setText(produto.getNome());
        valorTextField.setText(Double.toString(produto.getPrecoUnitario()));
        comboBox1.setSelectedItem(produto.getCodCategoria());
        codProdutoAtual = produto.getCodProduto();

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
                Produto produto = new Produto();
                int codCategoria;
                produto.setNome(nomeTextField.getText());
                produto.setPrecoUnitario(Double.parseDouble(valorTextField.getText()));
                codCategoria = daoCategoria.buscarCodCategoria(comboBox1.getSelectedItem().toString());
                produto.setCodCategoria(codCategoria);
                produto.setCodProduto(codProdutoAtual);

                daoProduto.alterarProduto(produto);

                Produtos produtos = new Produtos("Produtos");
                produtos.setVisible(true);
                dispose();
            }
        });
    }
}
