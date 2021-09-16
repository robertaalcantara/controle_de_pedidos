package model;

public class Item {
    private int codItem, codProduto, codPedido, qtd;
    private double precoUnitario;
    private String observacao;

    public Item(){}

    public Item(int codItem, int codProduto, int codPedido, int qtd, double precoUnitario, String observacao) {
        this.codItem = codItem;
        this.codProduto = codProduto;
        this.codPedido = codPedido;
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
        this.observacao = observacao;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}