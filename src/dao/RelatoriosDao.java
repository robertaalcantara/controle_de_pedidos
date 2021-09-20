package dao;

import model.Caixa;
import model.ConsultasRelatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RelatoriosDao {
    private Connection con = null;

    public RelatoriosDao(){
        con = Conexao.getConnection();
    }

    public ArrayList<ConsultasRelatorio> consulta1(){
        ArrayList<ConsultasRelatorio> lista = new ArrayList<>();

        String sql = "SELECT cliente.nome, saldo_devedor  FROM crediario, cliente" +
                " WHERE crediario.cod_cliente = cliente.cod_cliente" +
                " ORDER BY saldo_devedor DESC;";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                ConsultasRelatorio consultaCrediarioCliente = new ConsultasRelatorio();

                consultaCrediarioCliente.setNome(rs.getString("nome"));
                consultaCrediarioCliente.setSaldoDevedor(rs.getDouble("saldo_devedor"));

                lista.add(consultaCrediarioCliente);
            }
            rs.close();
            return lista;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Caixa consulta2(){
        Caixa caixa = new Caixa();

        String sql = "SELECT SUM(valor_total) as valor_total, SUM(valor_dinheiro) as valor_dinheiro," +
                " SUM(valor_debito) as valor_debito, SUM(valor_credito) as valor_credito, SUM(valor_crediario) as valor_crediario," +
                " SUM(valor_ifood) as valor_ifood FROM caixa" +
                " WHERE caixa.data BETWEEN '01-02-2021' AND '28-02-2021';";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            caixa.setValorTotal(rs.getDouble("valor_total"));
            caixa.setValorDinheiro(rs.getDouble("valor_dinheiro"));
            caixa.setValorDebito(rs.getDouble("valor_debito"));
            caixa.setValorCredito(rs.getDouble("valor_credito"));
            caixa.setValorCrediario(rs.getDouble("valor_crediario"));
            caixa.setValorIfood(rs.getDouble("valor_ifood"));

            rs.close();
            return caixa;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<ConsultasRelatorio> consulta3(){
        ArrayList<ConsultasRelatorio> lista = new ArrayList<>();

        String sql = "SELECT cliente.nome, COUNT(delivery.cod_pedido) AS num_pedidos FROM cliente, delivery, delivery_forma_pagamento" +
                " WHERE delivery.cod_cliente = cliente.cod_cliente" +
                " AND delivery_forma_pagamento.cod_pedido = delivery.cod_pedido" +
                " AND data_caixa BETWEEN '01-02-2021' AND '31-07-2021'" +
                " GROUP BY cliente.nome" +
                " ORDER BY num_pedidos DESC  LIMIT 3;";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                ConsultasRelatorio consultaCrediarioCliente = new ConsultasRelatorio();

                consultaCrediarioCliente.setNome(rs.getString("nome"));
                consultaCrediarioCliente.setNumeroPedidos(rs.getInt("num_pedidos"));

                lista.add(consultaCrediarioCliente);
            }
            rs.close();
            return lista;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
