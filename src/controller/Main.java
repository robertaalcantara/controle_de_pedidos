package controller;

import dao.*;
import model.Categoria;
import model.Cliente;
import model.Crediario;
import model.Endereco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       ArrayList<Categoria> lista = null;
       Categoria categoria = new Categoria();
       CategoriaDao daoCategoria = new CategoriaDao();
       int codCategoria;

       daoCategoria.excluirCategoria(7);

       //categoria.setCodCategoria(codCategoria);
       //categoria.setNome("blablabla");
       //daoCategoria.alterarCategoria(categoria);
       lista = daoCategoria.listarCategorias();

       // System.out.println(categoria.getCodCategoria()+", "+ categoria.getNome());


        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getCodCategoria() + ", " +
                    lista.get(i).getNome()+ ". \n ");
        }
    }
}
