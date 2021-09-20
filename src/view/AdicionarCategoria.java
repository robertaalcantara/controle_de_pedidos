package view;

import dao.CategoriaDao;
import model.Categoria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarCategoria extends JFrame{
    private JPanel mainPanel;
    private JTextField nomeCategoriaTextField;
    private JButton salvarButton;
    private JButton cancelarButton;

    public AdicionarCategoria(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
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
                //update tabela categoria
                CategoriaDao daoCategoria = new CategoriaDao();
                Categoria categoria = new Categoria();

                categoria.setNome(nomeCategoriaTextField.getText());
                daoCategoria.inserirCategoria(categoria);

                Produtos produtos = new Produtos("Produtos");
                produtos.setVisible(true);
                dispose();
            }
        });
    }
}
