package dao;

import model.Delivery;
import model.HistoricoCrediario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistoricoCrediarioDao {
    private Connection con = null;

    public HistoricoCrediarioDao(){
        con = Conexao.getConnection();
    }

    public void criarHistoricoCrediario(HistoricoCrediario  historicoCrediario){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO delivery_historico_crediario (cod_cliente, valor_crediario_pedido, data, cod_pedido) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, historicoCrediario.getCodCliente());
            stmt.setDouble(2, historicoCrediario.getValorCrediarioPedido());
            stmt.setDate(3, historicoCrediario.getData());
            stmt.setInt(4, historicoCrediario.getCodPedido());

            stmt.execute();
            System.out.println("\nHistorico crediario delivery adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<HistoricoCrediario> listarHistoricoCrediario(){
        ArrayList<HistoricoCrediario> listaHistoricoCrediario = new ArrayList<>();

        String sql = "SELECT * FROM delivery_historico_crediario";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                HistoricoCrediario historicoCrediario = new HistoricoCrediario();

                historicoCrediario.setIdCrediario(rs.getInt("id_crediario"));
                historicoCrediario.setCodPedido(rs.getInt("cod_pedido"));
                historicoCrediario.setCodCliente(rs.getInt("cod_cliente"));
                historicoCrediario.setData(rs.getDate("data"));
                historicoCrediario.setValorCrediarioPedido(rs.getDouble("valor_crediario_pedido"));

                listaHistoricoCrediario.add(historicoCrediario);
            }
            rs.close();
            return listaHistoricoCrediario;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<HistoricoCrediario> listarHistoricoCrediarioPorCliente(int codCliente){
        ArrayList<HistoricoCrediario> listaHistoricoCrediario = new ArrayList<>();

        String sql = "SELECT * FROM delivery_historico_crediario WHERE cod_cliente = " + codCliente;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                HistoricoCrediario historicoCrediario = new HistoricoCrediario();

                historicoCrediario.setIdCrediario(rs.getInt("id_crediario"));
                historicoCrediario.setCodPedido(rs.getInt("cod_pedido"));
                historicoCrediario.setCodCliente(rs.getInt("cod_cliente"));
                historicoCrediario.setData(rs.getDate("data"));
                historicoCrediario.setValorCrediarioPedido(rs.getDouble("valor_crediario_pedido"));

                listaHistoricoCrediario.add(historicoCrediario);
            }
            rs.close();
            return listaHistoricoCrediario;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }


    public HistoricoCrediario buscarHistoricoCrediario(int idCrediario){
        HistoricoCrediario historicoCrediario = new HistoricoCrediario();

        String sql = "SELECT * FROM delivery_historico_crediario WHERE id_crediario = "+ idCrediario;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            historicoCrediario.setIdCrediario(idCrediario);
            historicoCrediario.setCodPedido(rs.getInt("cod_pedido"));
            historicoCrediario.setCodCliente(rs.getInt("cod_cliente"));
            historicoCrediario.setData(rs.getDate("data"));
            historicoCrediario.setValorCrediarioPedido(rs.getDouble("valor_crediario_pedido"));

            rs.close();
            return historicoCrediario;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarHistoricoCrediario(HistoricoCrediario historicoCrediario){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE delivery_historico_crediario " +
                    "SET cod_cliente=?, cod_pedido=?, valor_crediario_pedido=?, data=? " +
                    "WHERE id_crediario= "+ historicoCrediario.getIdCrediario();
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, historicoCrediario.getCodCliente());
            stmt.setInt(2, historicoCrediario.getCodPedido());
            stmt.setDouble(3, historicoCrediario.getValorCrediarioPedido());
            stmt.setDate(4, historicoCrediario.getData());

            stmt.execute();
            System.out.println("\nHistorico crediario alterado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
