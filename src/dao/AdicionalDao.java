package dao;

import model.Adicional;
import model.ItemPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdicionalDao {
    private Connection con = null;

    public AdicionalDao(){
        con = Conexao.getConnection();
    }

    public void inserirAdicional(Adicional adicional){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO adiciona_item (cod_item, cod_item_adicional) VALUES (?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, adicional.getCodItem());
            stmt.setInt(2, adicional.getCodItemAdicional());

            stmt.execute();
            System.out.println("\nAdicional adicionado ao item no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Adicional> listarAdicionaisItens(){
        ArrayList<Adicional> listaAdicionaisItens = new ArrayList<>();

        String sql = "SELECT * FROM adiciona_item";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Adicional adicional = new Adicional();

                adicional.setCodItemAdicional(rs.getInt("cod_item_adicional"));
                adicional.setCodItem(rs.getInt("cod_item"));

                listaAdicionaisItens.add(adicional);
            }
            rs.close();
            return listaAdicionaisItens;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Adicional> listarAdicionaisPorItem(int codItem){
        ArrayList<Adicional> listaAdicionaisItem = new ArrayList<>();

        String sql = "SELECT * FROM adiciona_item WHERE cod_item = "+ codItem;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Adicional adicional = new Adicional();

                adicional.setCodItemAdicional(rs.getInt("cod_item_adicional"));
                adicional.setCodItem(rs.getInt("cod_item"));

                listaAdicionaisItem.add(adicional);
            }
            rs.close();
            return listaAdicionaisItem;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void excluirAdicionalItem(Adicional adicional){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "DELETE FROM adiciona_item " +
                    "WHERE cod_item = "+ adicional.getCodItem() +
                    " AND cod_item_adicional = "+ adicional.getCodItemAdicional();
            stmt = con.prepareStatement(sql);

            stmt.execute();
            System.out.println("\nAdicional/item excluído do Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
