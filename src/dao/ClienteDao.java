package dao;

import model.Cliente;
import model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao {
    private Connection con = null;

    public ClienteDao(){
        con = Conexao.getConnection();
    }

    public void inserirCliente(Cliente cliente){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();


            sql = "INSERT INTO cliente (nome, telefone, cod_endereco) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setInt(3, cliente.getCodEndereco());

            stmt.execute();
            System.out.println("\nCliente adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public ArrayList<Cliente> listarClientes(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Cliente cliente = new Cliente();

                cliente.setCodCliente(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCodEndereco(rs.getInt("cod_endereco"));

                listaClientes.add(cliente);
            }
            rs.close();
            return listaClientes;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Cliente buscarCliente(int codCliente){
        Cliente cliente = new Cliente();

        String sql = "SELECT * FROM cliente WHERE cod_cliente = "+ codCliente;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            cliente.setCodCliente(codCliente);
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCodEndereco(rs.getInt("cod_endereco"));

            rs.close();
            return cliente;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public int buscarCodCliente(Cliente cliente){
        int codCliente;

        String sql = "SELECT cod_cliente FROM cliente WHERE nome = '"+ cliente.getNome() +
                "' AND telefone = '"+ cliente.getTelefone() + "'";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            codCliente = rs.getInt("cod_cliente");

            rs.close();
            return codCliente;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return 0;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarCliente(Cliente cliente){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE cliente " +
                    "SET nome=?, telefone=?, cod_endereco=? " +
                    "WHERE cod_cliente = "+ cliente.getCodCliente();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setInt(3, cliente.getCodEndereco());

            stmt.execute();
            System.out.println("\nEndereço Alterado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
