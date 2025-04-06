package Main;

import Heritage.Aluno;
import database.dao.AlunoDAO;
import java.util.Scanner;

public class Portal {
    private Scanner scanner;
    private Aluno aluno;
    private JogoMatematico jogo;
    private OperacoesAritmeticas operacoes;
    private final String nomeEmpresa = "BELLÓS MATEMÁTICOS";

    public static void main(String[] args) {
        new Portal().executarPortal();
    }

    public Portal() {
        this.scanner = new Scanner(System.in);
    }

    public void executarPortal() {
        cadastro();
        navegacao();
        registrarDesempenhoNoBanco();
        scanner.close();
    }

    private void cadastro() {
        System.out.println(nomeEmpresa);
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu sexo (M/F): ");
        char sexo = scanner.next().charAt(0);
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        aluno = new Aluno(nome, sexo, idade);
        System.out.println(nome + ", seja bem-vindo ao portal aluno para cálculos e desafios matemáticos!");
    }

    private void navegacao() {
        int escolha;
        do {
            System.out.println("=================================");
            System.out.println("MENU DE NAVEGAÇÃO");
            System.out.println("1 - Acessar desafios matemáticos");
            System.out.println("2 - Acessar operações aritméticas");
            System.out.println("3 - Avaliar o portal");
            System.out.println("4 - Consultar dados");
            System.out.println("0 - Sair");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (escolha) {
                case 1 -> acessarDesafiosMatematicos();
                case 2 -> acessarOperacoesAritmeticas();
                case 3 -> avaliarNota();
                case 4 -> consultarDados();
                case 0 -> System.out.println("Saindo do portal...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (escolha != 0);
    }

    private void acessarDesafiosMatematicos() {
        System.out.println("Iniciando desafios matemáticos...");
        jogo = new JogoMatematico();
        jogo.iniciarJogo();
        jogo.mostrarResultadoFinal();
    }

    private void acessarOperacoesAritmeticas() {
        System.out.println("Iniciando operações aritméticas...");
        operacoes = new OperacoesAritmeticas(scanner);
        operacoes.executarCalculos();
    }

    private void avaliarNota() {
        int nota;
        String mensagemDefinida = "Obrigado por avaliar a " + nomeEmpresa;

        do {
            System.out.println("AVALIE O NOSSO PORTAL! \nDê sua nota: (1-10)");
            nota = scanner.nextInt();
        } while (nota < 1 || nota > 10);

        aluno.setNotaAvaliacao(nota);

        if (nota <= 3) {
            System.out.println("Precisamos melhorar bastante...");
        } else if (nota <= 6) {
            System.out.println("Ainda há espaço para melhorias");
        } else if (nota <= 8) {
            System.out.println("Bom trabalho! Estamos no caminho");
        } else if (nota == 9) {
            System.out.println("Ótimo! Quase perfeito!");
        } else {
            System.out.println("Perfeito! Ótimo desempenho!");
        }
        System.out.println(mensagemDefinida);
        System.out.println("=================================");
    }

    private void consultarDados() {
        int consult;
        do {
            System.out.println(aluno.getNome() + " quais de seus dados você deseja consultar no portal " + nomeEmpresa + "?");
            System.out.println("0 - Nenhum/Sair");
            System.out.println("1 - Dados Gerais");
            System.out.println("2 - Dados Pessoa");
            System.out.println("3 - Dados Aluno");
            consult = scanner.nextInt();
            switch (consult) {
                case 0 -> System.out.println("Programa finalizado! Obrigado por utilizar, " + aluno.getNome());
                case 1 -> aluno.exibirDados();
                case 2 -> aluno.exibirDadosPessoa();
                case 3 -> aluno.exibirDadosAluno();
                default -> System.out.println("Erro . . .");
            }
        } while (consult != 0);
    }

    private void registrarDesempenhoNoBanco() {
        if (jogo == null) jogo = new JogoMatematico(); // Evita null caso não jogue
        if (operacoes == null) operacoes = new OperacoesAritmeticas(scanner); // Evita null caso não use calculadora

        RegistroDesempenho registro = new RegistroDesempenho(aluno, jogo, operacoes);
        registro.registrarNoBanco();
    }
}
