package database.dao;

import Heritage.Aluno;
import Main.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {

    public void salvarAluno(Aluno aluno, int perguntasAcertadas, int totalCalculos) {
        String sql = "INSERT INTO aluno (nome, sexo, idade, nota, perguntas_acertadas, total_calculos) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, String.valueOf(aluno.getSexo()));
            stmt.setInt(3, aluno.getIdade());
            stmt.setInt(4, aluno.getNotaAvaliacao());
            stmt.setInt(5, perguntasAcertadas);
            stmt.setInt(6, totalCalculos);

            stmt.executeUpdate();
            System.out.println("✅ Aluno salvo com sucesso no banco de dados!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar aluno: " + e.getMessage());
        }
    }

    public void updateAluno(Aluno aluno, int perguntasAcertadas, int totalCalculos) {
        String sql = "UPDATE aluno SET sexo = ?, idade = ?, nota = ?, perguntas_acertadas = ?, total_calculos = ? " +
                "WHERE nome = ?";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, String.valueOf(aluno.getSexo()));
            stmt.setInt(2, aluno.getIdade());
            stmt.setInt(3, aluno.getNotaAvaliacao());
            stmt.setInt(4, perguntasAcertadas);
            stmt.setInt(5, totalCalculos);
            stmt.setString(6, aluno.getNome());

            stmt.executeUpdate();
            System.out.println("🔁 Aluno atualizado com sucesso no banco de dados!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    public boolean alunoExiste(String nome) {
        String sql = "SELECT 1 FROM aluno WHERE nome = ?";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // retorna true se encontrou um registro
        } catch (SQLException e) {
            System.out.println("❌ Erro ao verificar existência do aluno: " + e.getMessage());
            return false;
        }
    }

    public void salvarOuAtualizarAluno(Aluno aluno, int perguntasAcertadas, int totalCalculos) {
        if (alunoExiste(aluno.getNome())) {
            updateAluno(aluno, perguntasAcertadas, totalCalculos);
        } else {
            salvarAluno(aluno, perguntasAcertadas, totalCalculos);
        }
    }
}
