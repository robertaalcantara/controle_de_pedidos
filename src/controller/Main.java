package controller;

import dao.*;
import model.*;

import view.Pedidos;
import view.BalcaoDelivery;
import javax.swing.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws ParseException {
        BalcaoDelivery balcaoDelivery = new BalcaoDelivery("teste");
        balcaoDelivery.setVisible(true);


    }



}
