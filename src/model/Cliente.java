package model;

public class Cliente {
    private String nome, telefone;
    private int codCliente, codEndereco;

    public Cliente(){}

    public Cliente(String nome, String telefone, int codCliente, int codEndereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.codCliente = codCliente;
        this.codEndereco = codEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }
}
