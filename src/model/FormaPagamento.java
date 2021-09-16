package model;

public class FormaPagamento {
    private int codFormaPagamento;
    private String nome;

    public FormaPagamento(){}

    public FormaPagamento(int codFormaPagamento, String nome) {
        this.codFormaPagamento = codFormaPagamento;
        this.nome = nome;
    }

    public int getCodFormaPagamento() {
        return codFormaPagamento;
    }

    public void setCodFormaPagamento(int codFormaPagamento) {
        this.codFormaPagamento = codFormaPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
