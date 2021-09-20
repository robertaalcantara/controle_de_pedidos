package view;

import controller.ClienteAtual;
import dao.ClienteDao;
import dao.EnderecoDao;
import model.Cliente;
import model.Endereco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarCliente extends JFrame{
    Cliente clienteAtual = ClienteAtual.getUserAtual();
    Endereco endereco = ClienteAtual.getEnderecoUserAtual();
    ClienteDao daoCliente = new ClienteDao();
    EnderecoDao daoEndereco = new EnderecoDao();
    private JTextField nomeTextField;
    private JTextField telefoneTextField;
    private JTextField ruaTextField;
    private JTextField numeroTextField;
    private JTextField complementoTextField;
    private JTextField bairroTextField;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JPanel mainPanel;
    private JTextField freteTextField;


    public AlterarCliente(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        nomeTextField.setText(clienteAtual.getNome());
        telefoneTextField.setText(clienteAtual.getTelefone());
        ruaTextField.setText(endereco.getRua());
        bairroTextField.setText(endereco.getBairro());
        numeroTextField.setText(String.valueOf(endereco.getNumero()));
        complementoTextField.setText(endereco.getComplemento());
        freteTextField.setText(String.valueOf(endereco.getFrete()));

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes clientes = new Clientes("Clientes");
                clientes.setVisible(true);
                dispose();
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //update tabela cliente
                Endereco endereco = new Endereco();
                Cliente cliente = new Cliente();
                int codEndereco, codCliente;

                endereco.setRua(ruaTextField.getText());
                endereco.setBairro(bairroTextField.getText());
                endereco.setNumero(Integer.parseInt(numeroTextField.getText()));
                endereco.setFrete(Double.parseDouble(freteTextField.getText()));
                if(!complementoTextField.getText().isEmpty()){
                    endereco.setComplemento(complementoTextField.getText());
                }else{
                    endereco.setComplemento(null);
                }

                codEndereco = daoEndereco.buscarCodEndereco(endereco);

                if(codEndereco == 0){
                    daoEndereco.inserirEndereco(endereco);
                    codEndereco = daoEndereco.buscarCodEndereco(endereco);
                }
                endereco.setCodEndereco(codEndereco);

                cliente.setNome(nomeTextField.getText());
                cliente.setTelefone(telefoneTextField.getText());
                cliente.setCodCliente(clienteAtual.getCodCliente());
                cliente.setCodEndereco(codEndereco);
                daoCliente.alterarCliente(cliente);

                Clientes clientes = new Clientes("Cliente");
                clientes.setVisible(true);
                dispose();
            }
        });
    }
}
