package dao;

import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDao {
    private Connection con = null;

    public ProdutoDao(){
        con = Conexao.getConnection();
    }

    public void inserirProduto(Produto produto){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO produto (nome, preco_unit, cod_categoria) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setInt(3, produto.getCodCategoria());

            stmt.execute();
            System.out.println("\nProduto adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Produto> listarProdutos(){
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Produto produto = new Produto();

                produto.setCodProduto(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnitario(rs.getDouble("preco_unit"));
                produto.setCodCategoria(rs.getInt("cod_categoria"));

                listaProdutos.add(produto);
            }
            rs.close();
            return listaProdutos;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Produto> listarProdutosPorCategoria(int codCategoria){
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        String sql = "SELECT * FROM produto WHERE cod_categoria = "+codCategoria;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Produto produto = new Produto();

                produto.setCodProduto(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnitario(rs.getDouble("preco_unit"));
                produto.setCodCategoria(rs.getInt("cod_categoria"));

                listaProdutos.add(produto);
            }
            rs.close();
            return listaProdutos;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Produto> listarProdutosPorCategoriaENome(int codCategoria, String nome){
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        String sql = "SELECT * FROM produto WHERE cod_categoria = "+codCategoria +
                    " AND nome LIKE '%" + nome + "%'";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Produto produto = new Produto();

                produto.setCodProduto(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnitario(rs.getDouble("preco_unit"));
                produto.setCodCategoria(rs.getInt("cod_categoria"));

                listaProdutos.add(produto);
            }
            rs.close();
            return listaProdutos;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Produto buscarProduto(int codProduto){
        Produto produto = new Produto();

        String sql = "SELECT * FROM produto WHERE cod_produto = "+ codProduto;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            produto.setCodProduto(codProduto);
            produto.setNome(rs.getString("nome"));
            produto.setPrecoUnitario(rs.getDouble("preco_unit"));
            produto.setCodCategoria(rs.getInt("cod_categoria"));

            rs.close();
            return produto;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public int buscarCodProduto(String nome){
        int codProduto;

        String sql = "SELECT cod_produto FROM produto WHERE nome = '"+ nome + "'";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            codProduto = rs.getInt("cod_produto");

            rs.close();
            return codProduto;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return 0;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarProduto(Produto produto){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE produto " +
                    "SET nome=?, preco_unit=?, cod_categoria=? " +
                    "WHERE cod_produto = "+ produto.getCodProduto();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setInt(3, produto.getCodCategoria());

            stmt.execute();
            System.out.println("\nProduto alterado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void excluirProduto(int codProduto){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "DELETE FROM produto " +
                    "WHERE cod_produto = "+ codProduto;
            stmt = con.prepareStatement(sql);

            stmt.execute();
            System.out.println("\nProduto excluído do Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
