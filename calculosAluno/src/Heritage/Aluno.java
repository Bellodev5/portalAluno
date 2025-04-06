package Heritage;

public class Aluno extends Pessoa {
    private int notaAvaliacao = -1; // -1 indica que ainda não foi avaliado

    public Aluno(String nome, char sexo, int idade) {
        super(nome, sexo, idade);
    }

    public void setNotaAvaliacao(int nota) {
        this.notaAvaliacao = nota;
    }

    public int getNotaAvaliacao() {
        return notaAvaliacao;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        if (notaAvaliacao == -1) {
            System.out.println("Avaliação dada ao portal: (Ainda não avaliado)");
        } else {
            System.out.println("Avaliação dada ao portal: " + notaAvaliacao);
        }
    }


    public void exibirDadosAluno(){
        System.out.println("Avaliação do portal: " + (notaAvaliacao == -1 ? "(Ainda não avaliado)" : notaAvaliacao));
    }
}
