package controller;

import dao.*;
import model.*;

import javax.swing.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) throws ParseException {

       ArrayList<Delivery> lista = null;
       Delivery delivery = new Delivery();
       DeliveryDao daoDelivery = new DeliveryDao();

       int cod;
       String nome;

        DateFormat formato = new SimpleDateFormat("HH:mm");
        String hora = "20:12";
        Time tempo = new Time(formato.parse(hora).getTime());;

        /*delivery.setTempo(tempo);
        delivery.setCodCliente(1);
        delivery.setPrecoTotal(80);
        delivery.setCodPedido(9);
        delivery.setTroco(2.50);
        delivery.setCodPedido(32);*/

        delivery.setCodPedido(24);
        delivery = daoDelivery.buscarPedido(delivery.getCodPedido());

        System.out.println(
                delivery.getCodPedido() + ", " +
                        delivery.getCodCliente() + ", " +
                        delivery.getTempo() + ", " +
                        delivery.getTroco() + ", " +
                        delivery.getPrecoTotal() + ". \n ");

       /*lista = daoDelivery.listarPedidos();


        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getCodPedido() + ", " +
                     lista.get(i).getCodCliente() + ", " +
                   lista.get(i).getTempo() + ", " +
                    lista.get(i).getTroco() + ", " +
                    lista.get(i).getPrecoTotal() + ". \n ");
        }*/
    }
}
