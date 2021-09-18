package model;

import java.sql.Date;

public class Caixa {
    private Date data;
    private double valorTotal, valorDebito, valorCredito, valorCrediario, valorIfood, valorDinheiro;

    public Caixa(){}

    public Caixa(Date data, double valorTotal, double valorDebito, double valorCredito, double valorCrediario, double valorIfood, double valorDinheiro) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.valorDebito = valorDebito;
        this.valorCredito = valorCredito;
        this.valorCrediario = valorCrediario;
        this.valorIfood = valorIfood;
        this.valorDinheiro = valorDinheiro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(double valorDebito) {
        this.valorDebito = valorDebito;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getValorCrediario() {
        return valorCrediario;
    }

    public void setValorCrediario(double valorCrediario) {
        this.valorCrediario = valorCrediario;
    }

    public double getValorIfood() {
        return valorIfood;
    }

    public void setValorIfood(double valorIfood) {
        this.valorIfood = valorIfood;
    }

    public double getValorDinheiro() {
        return valorDinheiro;
    }

    public void setValorDinheiro(double valorDinheiro) {
        this.valorDinheiro = valorDinheiro;
    }
}
