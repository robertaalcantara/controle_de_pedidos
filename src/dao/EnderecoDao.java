package dao;

import model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDao {
    private Connection con = null;

    public EnderecoDao(){
        con = Conexao.getConnection();
    }

    public void inserirEndereco(Endereco endereco){
        String sql = "";
        PreparedStatement stmt;
        try {
            con = Conexao.getConnection();

            if(endereco.getComplemento() == null){
                sql = "INSERT INTO endereco (rua, bairro, numero, frete) VALUES (?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setDouble(4, endereco.getFrete());
            }else{
                sql = "INSERT INTO endereco (rua, bairro, numero, complemento, frete) VALUES (?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(4, endereco.getComplemento());
                stmt.setDouble(5, endereco.getFrete());
            }

            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setInt(3, endereco.getNumero());

            stmt.execute();
            System.out.println("\nEndereço Adicionado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
          Conexao.closeConnection(con);
        }
    }

    public ArrayList<Endereco> listarEnderecos(){
        ArrayList<Endereco> listaEnderecos = new ArrayList<>();

        String sql = "SELECT * FROM endereco";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Endereco endereco = new Endereco();

                endereco.setCodEndereco(rs.getInt("cod_endereco"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setFrete(rs.getDouble("frete"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setRua(rs.getString("rua"));

                listaEnderecos.add(endereco);
            }
            rs.close();
            return listaEnderecos;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public Endereco buscarEndereco(int codEndereco){
        Endereco endereco = new Endereco();

        String sql = "SELECT * FROM endereco WHERE cod_endereco = "+ codEndereco;

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            endereco.setCodEndereco(codEndereco);
            endereco.setBairro(rs.getString("bairro"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setFrete(rs.getDouble("frete"));
            endereco.setNumero(rs.getInt("numero"));
            endereco.setRua(rs.getString("rua"));

            rs.close();
            return endereco;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public int buscarCodEndereco(Endereco endereco){
        int codEndereco;

        String sql = "SELECT cod_endereco FROM endereco WHERE rua = '"+ endereco.getRua() +
                "' AND bairro = '"+ endereco.getBairro() +
                "' AND numero = "+ endereco.getNumero();

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            codEndereco = rs.getInt("cod_endereco");

            rs.close();
            return codEndereco;

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
            return 0;
        } finally {
            Conexao.closeConnection(con);
        }
    }

    public void alterarEndereco(Endereco endereco){
        String sql = "";
        PreparedStatement stmt;

        try {
            con = Conexao.getConnection();

            sql = "UPDATE endereco " +
                    "SET rua=?, bairro=?, numero=?, complemento=?, frete=? " +
                    "WHERE cod_endereco= "+endereco.getCodEndereco();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setInt(3, endereco.getNumero());
            stmt.setString(4, endereco.getComplemento());
            stmt.setDouble(5, endereco.getFrete());

            stmt.execute();
            System.out.println("\nEndereço Alterado no Banco de Dados\n");

        } catch (SQLException throwables) {
            System.out.println("Erro: " + throwables);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}