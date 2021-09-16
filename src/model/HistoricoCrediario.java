package model;

import java.util.Date;

public class HistoricoCrediario {
    private int idCrediario, codPedido, codCliente;
    private Date data;
    private double valorCrediarioPedido;

    public HistoricoCrediario(){}

    public HistoricoCrediario(int idCrediario, int codPedido, int codCliente, Date data, double valorCrediarioPedido) {
        this.idCrediario = idCrediario;
        this.codPedido = codPedido;
        this.codCliente = codCliente;
        this.data = data;
        this.valorCrediarioPedido = valorCrediarioPedido;
    }

    public int getIdCrediario() {
        return idCrediario;
    }

    public void setIdCrediario(int idCrediario) {
        this.idCrediario = idCrediario;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorCrediarioPedido() {
        return valorCrediarioPedido;
    }

    public void setValorCrediarioPedido(double valorCrediarioPedido) {
        this.valorCrediarioPedido = valorCrediarioPedido;
    }
}
