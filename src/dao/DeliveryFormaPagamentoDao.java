package dao;

import model.PedidoFormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryFormaPagamentoDao {
    private Connection con = null;

    public DeliveryFormaPagamentoDao(){
        con = Conexao.getConnection();
    }

    public void criarPedidoFormaPagamento(PedidoFormaPagamento pedidoFormaPagamento){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO delivery_forma_pagamento (cod_forma_pagamento, valor, data_caixa, cod_pedido, finalizado) VALUES (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, pedidoFormaPagamento.getCodFormaPagamento());
            stmt.setDouble(2, pedidoFormaPagamento.getValor());
            stmt.setDate(3, pedidoFormaPagamento.getDataCaixa());
            stmt.setInt(4, pedidoFormaPagamento.getCodPedido());
            stmt.setBoolean(5, pedidoFormaPagamento.isFinalizado());

            stmt.execute();
            System.out.println("\nPedido delivery/forma pagamento adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<PedidoFormaPagamento> listarPedidosFormaPagamento(){
        ArrayList<PedidoFormaPagamento> listaPedidosFormaPagamento = new ArrayList<>();

        String sql = "SELECT * FROM delivery_forma_pagamento";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                PedidoFormaPagamento pedidoFormaPagamento = new PedidoFormaPagamento();

                pedidoFormaPagamento.setCodFormaPagamento(rs.getInt("cod_forma_pagamento"));
                pedidoFormaPagamento.setCodPedido(rs.getInt("cod_pedido"));
                pedidoFormaPagamento.setFinalizado(rs.getBoolean("finalizado"));
                pedidoFormaPagamento.setDataCaixa(rs.getDate("data_caixa"));
                pedidoFormaPagamento.setValor(rs.getDouble("valor"));

                listaPedidosFormaPagamento.add(pedidoFormaPagamento);
            }
            rs.close();
            return listaPedidosFormaPagamento;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<PedidoFormaPagamento> listarPedidoPorFormaPagamento(int codFormaPagamento){
        ArrayList<PedidoFormaPagamento> listaPedidosFormaPagamento = new ArrayList<>();

        String sql = "SELECT * FROM delivery_forma_pagamento WHERE cod_forma_pagamento = " + codFormaPagamento;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                PedidoFormaPagamento pedidoFormaPagamento = new PedidoFormaPagamento();

                pedidoFormaPagamento.setCodFormaPagamento(codFormaPagamento);
                pedidoFormaPagamento.setCodPedido(rs.getInt("cod_pedido"));
                pedidoFormaPagamento.setFinalizado(rs.getBoolean("finalizado"));
                pedidoFormaPagamento.setDataCaixa(rs.getDate("data_caixa"));
                pedidoFormaPagamento.setValor(rs.getDouble("valor"));

                listaPedidosFormaPagamento.add(pedidoFormaPagamento);
            }
            rs.close();
            return listaPedidosFormaPagamento;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<PedidoFormaPagamento> listarPedidoFormaPagamentoPorStatus(boolean finalizado){
        ArrayList<PedidoFormaPagamento> listaPedidosFormaPagamento = new ArrayList<>();

        String sql = "SELECT * FROM delivery_forma_pagamento WHERE finalizado = " + finalizado;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                PedidoFormaPagamento pedidoFormaPagamento = new PedidoFormaPagamento();

                pedidoFormaPagamento.setCodFormaPagamento(rs.getInt("cod_forma_pagamento"));
                pedidoFormaPagamento.setCodPedido(rs.getInt("cod_pedido"));
                pedidoFormaPagamento.setFinalizado(finalizado);
                pedidoFormaPagamento.setDataCaixa(rs.getDate("data_caixa"));
                pedidoFormaPagamento.setValor(rs.getDouble("valor"));

                listaPedidosFormaPagamento.add(pedidoFormaPagamento);
            }
            rs.close();
            return listaPedidosFormaPagamento;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }
    public ArrayList<PedidoFormaPagamento> buscarFormasPagamentoPorPedido(int codPedido){
        ArrayList<PedidoFormaPagamento> listaPedidosFormaPagamento = new ArrayList<>();

        String sql = "SELECT * FROM delivery_forma_pagamento WHERE cod_pedido = " + codPedido;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                PedidoFormaPagamento pedidoFormaPagamento = new PedidoFormaPagamento();

                pedidoFormaPagamento.setCodFormaPagamento(rs.getInt("cod_forma_pagamento"));
                pedidoFormaPagamento.setCodPedido(codPedido);
                pedidoFormaPagamento.setFinalizado(rs.getBoolean("finalizado"));
                pedidoFormaPagamento.setDataCaixa(rs.getDate("data_caixa"));
                pedidoFormaPagamento.setValor(rs.getDouble("valor"));

                listaPedidosFormaPagamento.add(pedidoFormaPagamento);
            }
            rs.close();
            return listaPedidosFormaPagamento;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void excluirPedidoFormaPagamento(int codPedido, int codFormaPagamento){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "DELETE FROM delivery_forma_pagamento " +
                    "WHERE cod_forma_pagamento = "+ codFormaPagamento +
                    " AND cod_pedido = " + codPedido;
            stmt = con.prepareStatement(sql);

            stmt.execute();
            System.out.println("\nForma de pagamento/pedido excluído do Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
