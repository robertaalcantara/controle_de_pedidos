package controller;

import dao.ClienteDao;
import dao.Conexao;
import dao.CrediarioDao;
import dao.EnderecoDao;
import model.Cliente;
import model.Crediario;
import model.Endereco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       ArrayList<Crediario> lista = null;
       Crediario crediario = new Crediario();
       CrediarioDao daoCrediario = new CrediarioDao();

       //crediario.setCodCliente(8);
       //crediario.setSaldoDevedor(60.00);

       crediario = daoCrediario.buscarCrediarioCliente(8);

        System.out.println(crediario.getCodCliente()+", "+ crediario.getSaldoDevedor());

      /* lista = daoCrediario.listarCrediarioClientes();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getCodCliente() + ", " +
                    lista.get(i).getSaldoDevedor() + ". \n ");
        }*/
    }
}
