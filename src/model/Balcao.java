package model;

import java.sql.Time;

public class Balcao extends Pedido{
    private String nomeCliente;

    public Balcao(){}

    public Balcao(int codPedido, Time tempo, double precoTotal, String nomeCliente) {
        super(codPedido, tempo, precoTotal);
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
