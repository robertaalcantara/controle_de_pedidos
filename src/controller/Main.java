package controller;

import dao.*;
import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       ArrayList<Item> lista = null;
       Item item = new Item();
       ItemDao daoItem = new ItemDao();
       int codItem;


       daoItem.excluirItem(31);

       lista = daoItem.listarItens();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getCodItem() + ", " +
                    lista.get(i).getCodProduto() + ", " +
                    lista.get(i).getQtd() + ", " +
                    lista.get(i).getPrecoUnitario() + ", " +
                    lista.get(i).getObservacao()+ ". \n ");
        }
    }
}
