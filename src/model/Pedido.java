package model;

import java.sql.Time;

public class Pedido {
    private int codPedido;
    private double precoTotal;
    private Time tempo;

    public Pedido(){}

    public Pedido(int codPedido, Time tempo, double precoTotal) {
        this.codPedido = codPedido;
        this.tempo = tempo;
        this.precoTotal = precoTotal;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public Time getTempo() {
        return tempo;
    }

    public void setTempo(Time tempo) {
        this.tempo = tempo;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
