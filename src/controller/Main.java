package controller;

import dao.*;
import model.*;
import view.Clientes;
import view.Produtos;

import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

        //JFrame frame = new Clientes("Clientes");
        JFrame frame = new Produtos("Produtos");
        frame.setVisible(true);

    }
}
