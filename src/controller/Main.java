package controller;

import dao.*;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

       ArrayList<ItemPedido> lista = null;
       ItemPedido itemPedido = new ItemPedido();
       DeliveryItemPedidoDao daoDeliveryItemPedido = new DeliveryItemPedidoDao();

       int cod;
       String nome;

        itemPedido.setCodItem(2);
        itemPedido.setCodPedido(23);

        //daoDeliveryItemPedido.excluirItemPedido(itemPedido);
        lista = daoDeliveryItemPedido.listarItensPorPedido(itemPedido.getCodPedido());

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getCodItem() + ", " +
                    lista.get(i).getCodPedido() + ", " + ". \n ");
        }
    }
}
