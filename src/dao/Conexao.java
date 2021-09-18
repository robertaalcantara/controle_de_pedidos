package dao;

import java.sql.*;

public class Conexao {
    //Classe responsavel de abrir e fechar conexão do banco.
    private static final String DRIVER = "org.postgresql.Driver";

    //ENDERECO:PORTA/NOME_BANCO
    private static final String URL = "jdbc:postgresql://localhost:5432/burguer_e_cia";

    //Usuario e senha do banco que você define quando cria o banco.
    private static final String USER = "postgres";
    private static final String PASS = "4628";

    //Abre conexão com o banco.
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            System.out.println("oi");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro: " + ex);
            return null;
        }
    }

    //Fecha conexão com o banco.
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }
}
