package model;

public class Pedido {
    //tempo = tempo para o pedido ser entregue em minutos
    private int codPedido, tempo;
    private double precoTotal;

    public Pedido(){}

    public Pedido(int codPedido, int tempo, double precoTotal) {
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

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
