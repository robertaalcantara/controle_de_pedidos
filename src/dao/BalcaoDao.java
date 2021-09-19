package dao;

import model.Balcao;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BalcaoDao {
    private Connection con = null;

    public BalcaoDao(){
        con = Conexao.getConnection();
    }

    public void criarPedidoBalcao(Balcao balcao){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO balcao (nome_cliente, preco_total, tempo) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, balcao.getNomeCliente());
            stmt.setDouble(2, balcao.getPrecoTotal());
            stmt.setTime(3, balcao.getTempo());

            stmt.execute();
            System.out.println("\nPedido balcao adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Balcao> listarPedidos(){
        ArrayList<Balcao> listaPedidos = new ArrayList<>();

        String sql = "SELECT * FROM balcao";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Balcao balcao = new Balcao();

                balcao.setCodPedido(rs.getInt("cod_pedido"));
                balcao.setNomeCliente(rs.getString("nome_cliente"));
                balcao.setPrecoTotal(rs.getDouble("preco_total"));
                balcao.setTempo(rs.getTime("tempo"));

                listaPedidos.add(balcao);
            }
            rs.close();
            return listaPedidos;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Balcao buscarPedido(int codPedido){
        Balcao balcao = new Balcao();

        String sql = "SELECT * FROM balcao WHERE cod_pedido = "+ codPedido;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            balcao.setCodPedido(codPedido);
            balcao.setNomeCliente(rs.getString("nome_cliente"));
            balcao.setPrecoTotal(rs.getDouble("preco_total"));
            balcao.setTempo(rs.getTime("tempo"));

            rs.close();
            return balcao;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarPedido(Balcao balcao){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE balcao " +
                    "SET nome_cliente=?, preco_total=?, tempo=? " +
                    "WHERE cod_pedido = "+ balcao.getCodPedido();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, balcao.getNomeCliente());
            stmt.setDouble(2, balcao.getPrecoTotal());
            stmt.setTime(3, balcao.getTempo());

            stmt.execute();
            System.out.println("\nPedido Alterado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void excluirPedido(int codPedido){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "DELETE FROM balcao " +
                    "WHERE cod_pedido = "+ codPedido;
            stmt = con.prepareStatement(sql);

            stmt.execute();
            System.out.println("\nPedido excluído do Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
