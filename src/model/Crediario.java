package model;

public class Crediario {
    private int codCliente;
    private double saldoDevedor;

    public Crediario(){}

    public Crediario(int codCliente, double saldoDevedor) {
        this.codCliente = codCliente;
        this.saldoDevedor = saldoDevedor;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }
}
