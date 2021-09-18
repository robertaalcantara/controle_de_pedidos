package controller;

import dao.ClienteDao;
import dao.Conexao;
import dao.EnderecoDao;
import model.Cliente;
import model.Endereco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       /* EnderecoDao daoEndereco = new EnderecoDao();
        Endereco endereco = new Endereco();
        int codEndereco;

        //endereco.setCodEndereco(13);
        endereco.setRua("Nereu Ramos");
        endereco.setBairro("Claudete");
        endereco.setNumero(3111);
        endereco.setComplemento("fundos");
        endereco.setFrete(3.50);

        codEndereco = daoEndereco.buscarCodEndereco(endereco);
        System.out.println(codEndereco);
        System.out.println(endereco.getCodEndereco()+", "+
                endereco.getRua()+", "+
                endereco.getComplemento()+", "+
                endereco.getFrete()+". \n ");
       ArrayList<Endereco> lista = null;

        lista = daoEndereco.listarEnderecos();

       for(int i=0; i<lista.size(); i++) {
            System.out.println(lista.get(i).getCodEndereco()+", "+
                    lista.get(i).getRua()+", "+
                    lista.get(i).getComplemento()+", "+
                    lista.get(i).getFrete()+". \n ");
        }*/
        Cliente cliente = new Cliente();
        ClienteDao daoCliente = new ClienteDao();
        ArrayList<Cliente> lista = null;
        int codCli;

        cliente.setCodCliente(8);
        cliente.setNome("Roberta S. Alcantara");
        cliente.setTelefone("(45) 99745-2966");
        cliente.setCodEndereco(1);

        //daoCliente.alterarCliente(cliente);
        lista = daoCliente.listarClientes();

        //System.out.println(codCli);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getCodEndereco() + ", " +
                    lista.get(i).getCodCliente() + ", " +
                    lista.get(i).getNome() + ", " +
                    lista.get(i).getCodEndereco() + ", " +
                    lista.get(i).getTelefone() + ". \n ");
        }
    }
}
