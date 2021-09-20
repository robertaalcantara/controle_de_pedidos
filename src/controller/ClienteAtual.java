package controller;

import dao.EnderecoDao;
import model.Cliente;
import model.Endereco;

public class ClienteAtual {
    private static Cliente usuario;
    private static Endereco endereco;
    private static EnderecoDao daoEndereco;

    public static Cliente getUserAtual(){
        return usuario;
    }

    public static Endereco getEnderecoUserAtual(){
        return endereco;
    }

    public static void setUserAtual(Cliente cliente) {
        usuario = cliente;
        endereco = daoEndereco.buscarEndereco(cliente.getCodEndereco());
    }
}
