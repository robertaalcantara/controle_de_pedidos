package dao;

import model.Balcao;
import model.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDao {
    private Connection con = null;

    public DeliveryDao(){
        con = Conexao.getConnection();
    }

    public void criarPedidoDelivery(Delivery delivery){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO delivery (cod_cliente, preco_total, tempo, troco) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, delivery.getCodCliente());
            stmt.setDouble(2, delivery.getPrecoTotal());
            stmt.setTime(3, delivery.getTempo());
            stmt.setDouble(4, delivery.getTroco());

            stmt.execute();
            System.out.println("\nPedido delivery adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Delivery> listarPedidos(){
        ArrayList<Delivery> listaPedidos = new ArrayList<>();

        String sql = "SELECT * FROM delivery";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Delivery delivery = new Delivery();

                delivery.setCodPedido(rs.getInt("cod_pedido"));
                delivery.setCodCliente(rs.getInt("cod_cliente"));
                delivery.setPrecoTotal(rs.getDouble("preco_total"));
                delivery.setTroco(rs.getDouble("troco"));
                delivery.setTempo(rs.getTime("tempo"));

                listaPedidos.add(delivery);
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

    public Delivery buscarPedido(int codPedido){
        Delivery delivery = new Delivery();

        String sql = "SELECT * FROM delivery WHERE cod_pedido = "+ codPedido;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            delivery.setCodPedido(codPedido);
            delivery.setCodCliente(rs.getInt("cod_cliente"));
            delivery.setPrecoTotal(rs.getDouble("preco_total"));
            delivery.setTroco(rs.getDouble("troco"));
            delivery.setTempo(rs.getTime("tempo"));

            rs.close();
            return delivery;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarPedido(Delivery delivery){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE delivery " +
                    "SET cod_cliente=?, preco_total=?, tempo=?, troco= ? " +
                    "WHERE cod_pedido = "+ delivery.getCodPedido();
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, delivery.getCodCliente());
            stmt.setDouble(2, delivery.getPrecoTotal());
            stmt.setTime(3, delivery.getTempo());
            stmt.setDouble(4, delivery.getTroco());

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

            sql = "DELETE FROM delivery " +
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
