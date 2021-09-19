package controller;

import dao.*;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

       ArrayList<PedidoFormaPagamento> lista = null;
       PedidoFormaPagamento pedidoFormaPagamento = new PedidoFormaPagamento();
       DeliveryFormaPagamentoDao daoDeliveryFormaPagamento = new DeliveryFormaPagamentoDao();

       int cod;
       String nome;

        String dataString = "03/02/2021";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(format.parse(dataString).getTime());

        pedidoFormaPagamento.setCodFormaPagamento(2);
        pedidoFormaPagamento.setFinalizado(false);
        pedidoFormaPagamento.setCodPedido(31);
        pedidoFormaPagamento.setDataCaixa(data);
        pedidoFormaPagamento.setValor(22.00);


        lista = daoDeliveryFormaPagamento.listarPedidoFormaPagamentoPorStatus(true);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getCodFormaPagamento() + ", " +
                    lista.get(i).getCodPedido() + ", " +
                     lista.get(i).isFinalizado() + ", " +
                   lista.get(i).getDataCaixa() + ", " +
                    lista.get(i).getValor() + ". \n ");
        }
    }
}
