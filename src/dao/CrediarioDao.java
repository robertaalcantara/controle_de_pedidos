package dao;

import model.Cliente;
import model.Crediario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrediarioDao {
    private Connection con = null;

    public CrediarioDao(){
        con = Conexao.getConnection();
    }

    public void criarCrediario(Crediario crediario){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();


            sql = "INSERT INTO crediario (cod_cliente, saldo_devedor) VALUES (?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, crediario.getCodCliente());
            stmt.setDouble(2, crediario.getSaldoDevedor());

            stmt.execute();
            System.out.println("\nCrediario adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Crediario> listarCrediarioClientes(){
        ArrayList<Crediario> listaCrediario = new ArrayList<>();

        String sql = "SELECT * FROM crediario";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Crediario crediario = new Crediario();

                crediario.setCodCliente(rs.getInt("cod_cliente"));
                crediario.setSaldoDevedor(rs.getDouble("saldo_devedor"));

                listaCrediario.add(crediario);
            }
            rs.close();
            return listaCrediario;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Crediario buscarCrediarioCliente(int codCliente){
        Crediario crediario = new Crediario();

        String sql = "SELECT * FROM crediario WHERE cod_cliente = "+ codCliente;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            crediario.setCodCliente(codCliente);
            crediario.setSaldoDevedor(rs.getDouble("saldo_devedor"));

            rs.close();
            return crediario;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarCrediario(Crediario crediario){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE crediario " +
                    "SET saldo_devedor=? " +
                    "WHERE cod_cliente = "+ crediario.getCodCliente();
            stmt = con.prepareStatement(sql);

            stmt.setDouble(1, crediario.getSaldoDevedor());

            stmt.execute();
            System.out.println("\nCrediario alterado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
