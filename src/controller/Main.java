package controller;

import dao.*;
import model.*;
import view.Clientes;
import view.Pedidos;

import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

        JFrame frame = new Pedidos("Clientes");
        frame.setVisible(true);

    }
}
