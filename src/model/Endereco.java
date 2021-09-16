package model;

public class Endereco {
    private String bairro, rua, complemento;
    private int codEndereco, numero;
    private double frete;

    public Endereco(){}

    public Endereco(String bairro, String rua, String complemento, int codEndereco, int numero, double frete) {
        this.bairro = bairro;
        this.rua = rua;
        this.complemento = complemento;
        this.codEndereco = codEndereco;
        this.numero = numero;
        this.frete = frete;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }
}
