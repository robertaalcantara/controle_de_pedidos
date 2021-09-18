package controller;

import dao.Conexao;
import dao.EnderecoDao;
import model.Cliente;
import model.Endereco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EnderecoDao daoEndereco = new EnderecoDao();
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
        /*System.out.println(endereco.getCodEndereco()+", "+
                endereco.getRua()+", "+
                endereco.getComplemento()+", "+
                endereco.getFrete()+". \n ");*/
       ArrayList<Endereco> lista = null;

        lista = daoEndereco.listarEnderecos();

     /*   for(int i=0; i<lista.size(); i++) {
            System.out.println(lista.get(i).getCodEndereco()+", "+
                    lista.get(i).getRua()+", "+
                    lista.get(i).getComplemento()+", "+
                    lista.get(i).getFrete()+". \n ");
        }*/
    }
}
