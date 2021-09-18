package dao;

import model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDao {
    private Connection con = null;

    public ItemDao(){
        con = Conexao.getConnection();
    }

    public void inserirItem(Item item){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO item (qtd, preco_unit, observacao, cod_produto) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, item.getQtd());
            stmt.setDouble(2, item.getPrecoUnitario());
            stmt.setString(3, item.getObservacao());
            stmt.setInt(4, item.getCodProduto());

            stmt.execute();
            System.out.println("\nItem adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Item> listarItens(){
        ArrayList<Item> listaItens = new ArrayList<>();

        String sql = "SELECT * FROM item";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Item item = new Item();

                item.setCodItem(rs.getInt("cod_item"));
                item.setQtd(rs.getInt("qtd"));
                item.setPrecoUnitario(rs.getDouble("preco_unit"));
                item.setObservacao(rs.getString("observacao"));
                item.setCodProduto(rs.getInt("cod_produto"));

                listaItens.add(item);
            }
            rs.close();
            return listaItens;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Item buscarItem(int codItem){
        Item item = new Item();

        String sql = "SELECT * FROM item WHERE cod_item = "+ codItem;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            item.setCodItem(codItem);
            item.setCodProduto(rs.getInt("cod_produto"));
            item.setObservacao(rs.getString("observacao"));
            item.setPrecoUnitario(rs.getDouble("preco_unit"));
            item.setQtd(rs.getInt("qtd"));

            rs.close();
            return item;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarItem(Item item){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE item " +
                    "SET qtd=?, preco_unit=?, observacao=?, cod_produto=? " +
                    "WHERE cod_item = "+ item.getCodItem();
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, item.getQtd());
            stmt.setDouble(2, item.getPrecoUnitario());
            stmt.setString(3, item.getObservacao());
            stmt.setInt(4, item.getCodProduto());

            stmt.execute();
            System.out.println("\nItem alterado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void excluirItem(int codItem){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "DELETE FROM item " +
                    "WHERE cod_item = "+ codItem;
            stmt = con.prepareStatement(sql);

            stmt.execute();
            System.out.println("\nItem excluído do Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
