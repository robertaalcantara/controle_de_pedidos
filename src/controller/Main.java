package controller;

import dao.*;
import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       ArrayList<Produto> lista = null;
        Produto produto = new Produto();
        ProdutoDao daoProduto = new ProdutoDao();
       int codProduto;

       daoProduto.excluirProduto(37);

       lista = daoProduto.listarProdutosPorCategoria(5);

       // System.out.println(categoria.getCodCategoria()+", "+ categoria.getNome());


        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getCodProduto() + ", " +
                    lista.get(i).getCodCategoria() + ", " +
                    lista.get(i).getPrecoUnitario() + ", " +
                    lista.get(i).getNome()+ ". \n ");
        }
    }
}
