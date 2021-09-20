package controller;

import dao.EnderecoDao;
import model.Cliente;
import model.Endereco;

public class ClienteDeliveryAtual {
    private static Cliente usuario;
    private static Endereco endereco;
    private static EnderecoDao daoEndereco;

    public static Cliente getClienteAtual(){
        return usuario;
    }

    public static Endereco getEnderecoClienteAtual(){
        return endereco;
    }

    public static void setClienteAtual(Cliente cliente) {
        usuario = cliente;
        endereco = daoEndereco.buscarEndereco(cliente.getCodEndereco());
    }
}
