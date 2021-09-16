package model;

public class Categoria {
    private int codCategoria;
    private String nome;

    public Categoria(int codCategoria, String nome) {
        this.codCategoria = codCategoria;
        this.nome = nome;
    }

    public Categoria(){

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
