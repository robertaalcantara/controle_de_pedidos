package model;

public class Produto {
    private int codProduto, codCategoria;
    private String nome;

    public Produto(){}

    public Produto(int codProduto, int codCategoria, String nome) {
        this.codProduto = codProduto;
        this.codCategoria = codCategoria;
        this.nome = nome;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
