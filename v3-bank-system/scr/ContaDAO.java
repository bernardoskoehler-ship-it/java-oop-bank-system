package org.example;

import javax.xml.transform.Result;
import java.sql.*;

public class ContaDAO {

    Connection conexao;

    public ContaDAO() throws Exception {
        conexao = DriverManager.getConnection("jdbc:sqlite:banco.db");
    }

    public void criar_TabelaConta() throws Exception {

        String sql = "CREATE TABLE IF NOT EXISTS contas(id INTEGER PRIMARY KEY, nome TEXT, senha TEXT, saldo DOUBLE, limite DOUBLE, contaAtiva BOOLEAN);";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public void inserir_TabelaConta(String nome, String senha) throws Exception {

        String sql = "INSERT INTO contas(nome, senha, saldo, limite, contaAtiva) VALUES(?,?,0,2500,false)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, senha);

            stmt.executeUpdate();
        }

        System.out.println("Novo usuario inserido!");
    }

    public void atualizarSaldo_TabelaConta(int id, double saldo) throws Exception {

        String sql = "UPDATE contas SET saldo = ? WHERE id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setDouble(1, saldo);
        stmt.setInt(2, id);

        stmt.executeUpdate();

        stmt.close();
    }

    public void atualizarContaAtiva_TabelaConta(int id, boolean ativa) throws Exception {

        String sql = "UPDATE contas SET contaAtiva = ? WHERE id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setBoolean(1, ativa);
        stmt.setInt(2, id);

        stmt.executeUpdate();

        stmt.close();
    }

    public Conta mostrarId_TabelaConta(int id) throws Exception {

        String sql = "SELECT * FROM contas WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if(rs.next()) {
                    return new Conta(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("senha"),
                            rs.getDouble("saldo"),
                            rs.getDouble("limite"),
                            rs.getBoolean("contaAtiva")
                    );
                }
            }
        }

        return null;
    }

    public Conta mostrarNome_TabelaConta(String nome) throws Exception {

        String sql = "SELECT * FROM contas WHERE nome = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {

                if(rs.next()) {
                    return new Conta(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("senha"),
                            rs.getDouble("saldo"),
                            rs.getDouble("limite"),
                            rs.getBoolean("contaAtiva")
                    );
                }
            }
        }

        return null;
    }
    public void desativarTodasContas() throws Exception {

        String sql = "UPDATE contas SET contaAtiva = false";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }


}
