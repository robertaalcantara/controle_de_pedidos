package model;

public class Delivery extends Pedido{
    private int codCliente;
    private double troco;

    public Delivery(){
    }

    public Delivery(int codPedido, int tempo, double precoTotal, int codCliente, double troco) {
        super(codPedido, tempo, precoTotal);
        this.codCliente = codCliente;
        this.troco = troco;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }
}
