package dao;

import model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDao {
    private Connection con = null;

    public CategoriaDao(){
        con = Conexao.getConnection();
    }

    public void inserirCategoria(Categoria categoria){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO categoria (nome) VALUES (?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());

            stmt.execute();
            System.out.println("\nCategoria adicionada no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Categoria> listarCategorias(){
        ArrayList<Categoria> listaCategoria = new ArrayList<>();

        String sql = "SELECT * FROM categoria";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Categoria categoria = new Categoria();

                categoria.setCodCategoria(rs.getInt("cod_categoria"));
                categoria.setNome(rs.getString("nome"));

                listaCategoria.add(categoria);
            }
            rs.close();
            return listaCategoria;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Categoria buscarCategoria(int codCategoria){
        Categoria categoria = new Categoria();

        String sql = "SELECT * FROM categoria WHERE cod_categoria = "+ codCategoria;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            categoria.setCodCategoria(codCategoria);
            categoria.setNome(rs.getString("nome"));

            rs.close();
            return categoria;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public int buscarCodCategoria(String nome){
        int codCategoria;

        String sql = "SELECT cod_categoria FROM categoria WHERE nome = '"+ nome+"'";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            codCategoria = rs.getInt("cod_categoria");

            rs.close();
            return codCategoria;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return 0;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarCategoria(Categoria categoria){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE categoria " +
                    "SET nome=? " +
                    "WHERE cod_categoria = "+ categoria.getCodCategoria();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());

            stmt.execute();
            System.out.println("\nCategoria alterada no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void excluirCategoria(int codCategoria){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "DELETE FROM categoria " +
                    "WHERE cod_categoria = "+ codCategoria;
            stmt = con.prepareStatement(sql);

            stmt.execute();
            System.out.println("\nCategoria excluída do Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
