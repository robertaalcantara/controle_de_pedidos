package dao;

import model.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormaPagamentoDao {
    private Connection con = null;

    public FormaPagamentoDao(){
        con = Conexao.getConnection();
    }

    public void inserirFormaPagamento(FormaPagamento formaPagamento){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO forma_pagamento (nome) VALUES (?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, formaPagamento.getNome());

            stmt.execute();
            System.out.println("\nForma de pagamento adicionada no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<FormaPagamento> listarFormasPagamento(){
        ArrayList<FormaPagamento> listaFormasPagamento = new ArrayList<>();

        String sql = "SELECT * FROM forma_pagamento";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                FormaPagamento formaPagamento = new FormaPagamento();

                formaPagamento.setCodFormaPagamento(rs.getInt("cod_forma_pagamento"));
                formaPagamento.setNome(rs.getString("nome"));

                listaFormasPagamento.add(formaPagamento);
            }
            rs.close();
            return listaFormasPagamento;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public FormaPagamento buscarFormaPagamento(int codFormaPagamento){
        FormaPagamento formaPagamento = new FormaPagamento();

        String sql = "SELECT * FROM forma_pagamento WHERE cod_forma_pagamento = "+ codFormaPagamento;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            formaPagamento.setCodFormaPagamento(codFormaPagamento);
            formaPagamento.setNome(rs.getString("nome"));

            rs.close();
            return formaPagamento;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public int buscarCodFormaPagamento(String nome){
        int codFormaPagamento;

        String sql = "SELECT cod_forma_pagamento FROM forma_pagamento WHERE nome = '"+ nome+"'";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            codFormaPagamento = rs.getInt("cod_forma_pagamento");

            rs.close();
            return codFormaPagamento;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return 0;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarFormaPagamento(FormaPagamento formaPagamento){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE forma_pagamento " +
                    "SET nome=? " +
                    "WHERE cod_forma_pagamento = "+ formaPagamento.getCodFormaPagamento();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, formaPagamento.getNome());

            stmt.execute();
            System.out.println("\nForma de pagamento alterada no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void excluirFormaPagamento(int codFormaPagamento){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "DELETE FROM forma_pagamento " +
                    "WHERE cod_forma_pagamento = "+ codFormaPagamento;
            stmt = con.prepareStatement(sql);

            stmt.execute();
            System.out.println("\nForma de pagamento excluída do Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
