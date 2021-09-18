package controller;

import dao.*;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

       ArrayList<Caixa> lista = null;
       Caixa caixa = new Caixa();
       CaixaDao daoCaixa = new CaixaDao();
       int codItem;

        String dataString = "25/04/2021";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(format.parse(dataString).getTime());

        caixa = daoCaixa.buscarCaixa(data);

        System.out.println(
                caixa.getData() + ", " +
                        caixa.getValorTotal() + ", " +
                        caixa.getValorIfood() + ", " +
                        caixa.getValorDinheiro() + ", " +
                        caixa.getValorDebito() + ", " +
                        caixa.getValorCredito() + ", " +
                        caixa.getValorCrediario()+ ". \n ");

      /* lista = daoCaixa.listarCaixas();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getData() + ", " +
                    lista.get(i).getValorTotal() + ", " +
                    lista.get(i).getValorIfood() + ", " +
                    lista.get(i).getValorDinheiro() + ", " +
                    lista.get(i).getValorDebito() + ", " +
                    lista.get(i).getValorCredito() + ", " +
                    lista.get(i).getValorCrediario()+ ". \n ");
        }*/
    }
}
