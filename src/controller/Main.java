package controller;

import dao.*;
import model.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

       ArrayList<Adicional> lista = null;
       Adicional adicional = new Adicional();
       AdicionalDao daoAdicional = new AdicionalDao();

       int cod;
       String nome;

        adicional.setCodItem(3);
        adicional.setCodItemAdicional(27);

        //daoAdicional.excluirAdicionalItem(adicional);
        lista = daoAdicional.listarAdicionaisItens();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getCodItem() + ", " +
                    lista.get(i).getCodItemAdicional() + ", " + ". \n ");
        }
    }
}
