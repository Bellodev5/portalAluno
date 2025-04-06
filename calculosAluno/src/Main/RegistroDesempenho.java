package Main;

import Heritage.Aluno;
import database.dao.AlunoDAO;

public class RegistroDesempenho {
    private Aluno aluno;
    private JogoMatematico jogo;
    private OperacoesAritmeticas operacoes;

    public RegistroDesempenho(Aluno aluno, JogoMatematico jogo, OperacoesAritmeticas operacoes) {
        this.aluno = aluno;
        this.jogo = jogo;
        this.operacoes = operacoes;
    }

    public void registrarNoBanco() {
        int totalAcertos = jogo.getTotalAcertos();
        int totalCalculos = operacoes.getTotalCalculos();

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.salvarOuAtualizarAluno(aluno, totalAcertos, totalCalculos);
    }
}
