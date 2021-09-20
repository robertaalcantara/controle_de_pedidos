package controller;

import dao.*;
import model.*;
import view.Clientes;

import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

        JFrame frame = new Clientes("Clientes");
        frame.setVisible(true);

    }
}
