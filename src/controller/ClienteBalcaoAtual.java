package controller;

public class ClienteBalcaoAtual {
    private static String name;

    public static String getClienteAtual(){
        return name;
    }

    public static void setClienteAtual(String nome){
        name = nome;
    }
}
