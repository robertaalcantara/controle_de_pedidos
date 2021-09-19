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

       ArrayList<Balcao> lista = null;
       Balcao balcao = new Balcao();
       BalcaoDao daoBalcao = new BalcaoDao();
       int cod;
       String nome;

        DateFormat formato = new SimpleDateFormat("HH:mm");
        String hora = "20:12";
        Time tempo = new Time(formato.parse(hora).getTime());;

        /*balcao.setTempo(tempo);
        balcao.setNomeCliente("José Ricardo");
        balcao.setPrecoTotal(50.90);
        balcao.setCodPedido(9);*/

        daoBalcao.excluirPedido(9);

       lista = daoBalcao.listarPedidos();


        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getCodPedido() + ", " +
                     lista.get(i).getNomeCliente() + ", " +
                   lista.get(i).getTempo() + ", " +
                    lista.get(i).getPrecoTotal() + ", " +
                    lista.get(i).getPrecoTotal() + ". \n ");
        }
    }
}
