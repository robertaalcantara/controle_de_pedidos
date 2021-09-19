package controller;

import dao.*;
import model.*;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

       ArrayList<FormaPagamento> lista = null;
       FormaPagamento formaPagamento = new FormaPagamento();
       FormaPagamentoDao daoFormaPagamento = new FormaPagamentoDao();
       int cod;
       String nome;

       formaPagamento = daoFormaPagamento.buscarFormaPagamento(6);

        daoFormaPagamento.excluirFormaPagamento(formaPagamento.getCodFormaPagamento());
        lista = daoFormaPagamento.listarFormasPagamento();

        /*System.out.println(
                caixa.getData() + ", " +
                        caixa.getValorTotal() + ", " +
                        caixa.getValorIfood() + ", " +
                        caixa.getValorDinheiro() + ", " +
                        caixa.getValorDebito() + ", " +
                        caixa.getValorCredito() + ", " +
                        caixa.getValorCrediario()+ ". \n ");*/

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getCodFormaPagamento() + ", " +
                    /* lista.get(i).getNome() + ", " +
                   lista.get(i).getValorIfood() + ", " +
                    lista.get(i).getValorDinheiro() + ", " +
                    lista.get(i).getValorDebito() + ", " +
                    lista.get(i).getValorCredito() + ", " +*/
                    lista.get(i).getNome() + ". \n ");
        }
    }
}
