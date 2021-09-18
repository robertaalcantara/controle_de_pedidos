package dao;

import model.Caixa;
import model.Produto;
import java.sql.*;
import java.util.ArrayList;

public class CaixaDao {
    private Connection con = null;

    public CaixaDao(){
        con = Conexao.getConnection();
    }

    public void criarCaixa(Caixa caixa){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            sql = "INSERT INTO caixa (data, valor_total, valor_dinheiro, valor_debito, valor_credito, valor_crediario, valor_ifood) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setDate(1, caixa.getData());
            stmt.setDouble(2, caixa.getValorTotal());
            stmt.setDouble(3, caixa.getValorDinheiro());
            stmt.setDouble(4, caixa.getValorDebito());
            stmt.setDouble(5, caixa.getValorCredito());
            stmt.setDouble(6, caixa.getValorCrediario());
            stmt.setDouble(7, caixa.getValorIfood());

            stmt.execute();
            System.out.println("\nCaixa criado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Caixa> listarCaixas(){
        ArrayList<Caixa> listaCaixas = new ArrayList<>();

        String sql = "SELECT * FROM caixa";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Caixa caixa = new Caixa();

                caixa.setData(rs.getDate("data"));
                caixa.setValorTotal(rs.getDouble("valor_total"));
                caixa.setValorDinheiro(rs.getDouble("valor_dinheiro"));
                caixa.setValorDebito(rs.getDouble("valor_debito"));
                caixa.setValorCredito(rs.getDouble("valor_credito"));
                caixa.setValorCrediario(rs.getDouble("valor_crediario"));
                caixa.setValorIfood(rs.getDouble("valor_ifood"));

                listaCaixas.add(caixa);
            }
            rs.close();
            return listaCaixas;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Caixa buscarCaixa(Date data){
        Caixa caixa = new Caixa();

        String sql = "SELECT * FROM caixa WHERE data = '"+ data +"'";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            caixa.setData(data);
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

    public void alterarCaixa(Caixa caixa){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE caixa " +
                    "SET valor_total=?, valor_dinheiro=?, valor_debito=?, valor_credito=?, valor_crediario=?, valor_ifood=? " +
                    "WHERE data = '"+ caixa.getData() + "'";
            stmt = con.prepareStatement(sql);

            stmt.setDouble(1, caixa.getValorTotal());
            stmt.setDouble(2, caixa.getValorDinheiro());
            stmt.setDouble(3, caixa.getValorDebito());
            stmt.setDouble(4, caixa.getValorCredito());
            stmt.setDouble(5, caixa.getValorCrediario());
            stmt.setDouble(6, caixa.getValorIfood());

            stmt.execute();
            System.out.println("\nCaixa alterado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
