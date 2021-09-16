package model;

public class Balcao extends Pedido{
    private String nomeCliente;

    public Balcao(){}

    public Balcao(int codPedido, int tempo, double precoTotal, String nomeCliente) {
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
