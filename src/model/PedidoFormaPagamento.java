package model;

import java.util.Date;

public class PedidoFormaPagamento {
    private Date dataCaixa;
    private double valor;
    private int codPedido,codFormaPagamento;
    private boolean isFinalizado;

    public PedidoFormaPagamento(){}

    public PedidoFormaPagamento(Date dataCaixa, double valor, int codPedido, int codFormaPagamento, boolean isFinalizado) {
        this.dataCaixa = dataCaixa;
        this.valor = valor;
        this.codPedido = codPedido;
        this.codFormaPagamento = codFormaPagamento;
        this.isFinalizado = isFinalizado;
    }

    public Date getDataCaixa() {
        return dataCaixa;
    }

    public void setDataCaixa(Date dataCaixa) {
        this.dataCaixa = dataCaixa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodFormaPagamento() {
        return codFormaPagamento;
    }

    public void setCodFormaPagamento(int codFormaPagamento) {
        this.codFormaPagamento = codFormaPagamento;
    }

    public boolean isFinalizado() {
        return isFinalizado;
    }

    public void setFinalizado(boolean finalizado) {
        isFinalizado = finalizado;
    }
}
