package controller;

import dao.*;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

       ArrayList<HistoricoCrediario> lista = null;
       HistoricoCrediario historicoCrediario = new HistoricoCrediario();
       DeliveryHistoricoCrediarioDao daoHistoricoCrediario = new DeliveryHistoricoCrediarioDao();

       int cod;
       String nome;

        String dataString = "20/09/2021";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(format.parse(dataString).getTime());

        historicoCrediario.setValorCrediarioPedido(35.50);
        historicoCrediario.setCodCliente(8);
        historicoCrediario.setCodPedido(31);
        historicoCrediario.setData(data);
        historicoCrediario.setIdCrediario(10);

        historicoCrediario = daoHistoricoCrediario.buscarHistoricoCrediario(5);

        System.out.println(
                historicoCrediario.getIdCrediario() + ", " +
                        historicoCrediario.getCodPedido() + ", " +
                        historicoCrediario.getCodCliente() + ", " +
                        historicoCrediario.getData() + ", " +
                        historicoCrediario.getValorCrediarioPedido() + ". \n ");

       /* for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getIdCrediario() + ", " +
                    lista.get(i).getCodPedido() + ", " +
                     lista.get(i).getCodCliente() + ", " +
                   lista.get(i).getData() + ", " +
                    lista.get(i).getValorCrediarioPedido() + ". \n ");
        }*/
    }
}
