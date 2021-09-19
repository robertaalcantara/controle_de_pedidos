package dao;

import model.ItemPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BalcaoItemPedidoDao {
    private Connection con = null;

    public BalcaoItemPedidoDao(){
        con = Conexao.getConnection();
    }

    public void inserirItemPedido(ItemPedido itemPedido){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO balcao_item_pedido (cod_item, cod_pedido) VALUES (?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, itemPedido.getCodItem());
            stmt.setInt(2, itemPedido.getCodPedido());

            stmt.execute();
            System.out.println("\nItem/pedido balcao adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<ItemPedido> listarItensPedido(){
        ArrayList<ItemPedido> listaItensPedido = new ArrayList<>();

        String sql = "SELECT * FROM balcao_item_pedido";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                ItemPedido itemPedido = new ItemPedido();

                itemPedido.setCodPedido(rs.getInt("cod_pedido"));
                itemPedido.setCodItem(rs.getInt("cod_item"));

                listaItensPedido.add(itemPedido);
            }
            rs.close();
            return listaItensPedido;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<ItemPedido> listarItensPorPedido(int codPedido){
        ArrayList<ItemPedido> listaItensPedido = new ArrayList<>();

        String sql = "SELECT * FROM balcao_item_pedido WHERE cod_pedido = "+ codPedido;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                ItemPedido itemPedido = new ItemPedido();

                itemPedido.setCodPedido(rs.getInt("cod_pedido"));
                itemPedido.setCodItem(rs.getInt("cod_item"));

                listaItensPedido.add(itemPedido);
            }
            rs.close();
            return listaItensPedido;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void excluirItemPedido(ItemPedido itemPedido){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "DELETE FROM balcao_item_pedido " +
                    "WHERE cod_item = "+ itemPedido.getCodItem() +
                    " AND cod_pedido = "+ itemPedido.getCodPedido();
            stmt = con.prepareStatement(sql);

            stmt.execute();
            System.out.println("\nItem/pedido excluído do Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
