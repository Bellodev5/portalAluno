package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class JogoMatematico {
    private final Scanner scanner;
    private final Random random;
    private final Map<String, Integer> perguntasFaceis;
    private final Map<String, Integer> perguntasMedias;
    private final Map<String, Integer> perguntasDificeis;

    private int acertosFaceis = 0;
    private int acertosMedios = 0;
    private int acertosDificeis = 0;

    public JogoMatematico() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();

        perguntasFaceis = new HashMap<>();
        perguntasFaceis.put("Quanto é 122 + 32?", 154);
        perguntasFaceis.put("Quanto é 25 - 3?", 22);
        perguntasFaceis.put("Quanto é 6 x 1?", 6);
        perguntasFaceis.put("Quanto é 95 + 57?", 152);

        perguntasMedias = new HashMap<>();
        perguntasMedias.put("Qual é a raiz quadrada de 144", 12);
        perguntasMedias.put(" Qual é a raiz cúbica de 27?", 3);
        perguntasMedias.put("Uma esfera tem raio de 6 cm. Qual é a sua área superficial?", 144);
        perguntasMedias.put("Quanto é 36 ÷ 6?", 6);

        perguntasDificeis = new HashMap<>();
        perguntasDificeis.put("Um cilindro tem altura de 10 cm e raio da base de 5 cm. Qual é o seu volume?", 250);
        perguntasDificeis.put("Se a raiz quadrada de um número é 7, qual é esse número?", 49);
        perguntasDificeis.put(" Um cilindro tem volume de 500π cm³ e altura de 10 cm. Qual é o raio da base?", 7);
        perguntasDificeis.put("Um cone tem raio de 4 cm e altura de 9 cm. Qual é o volume do cone?", 48);
    }

    public void iniciarJogo() {
        int opcaoQuiz;

        do {
            System.out.println("=== MENU QUIZ ===");
            System.out.println("0 - Sair do Quiz");
            System.out.println("1 - Responder perguntas");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite 1 para jogar ou 0 para sair.");
                scanner.next();
            }
            opcaoQuiz = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoQuiz) {
                case 1 -> responderPerguntas();
                case 0 -> System.out.println("Saindo do Quiz.");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcaoQuiz != 0);
    }

    private void responderPerguntas() {
        String nivel;
        String continuar ="";

        do {
            System.out.println("Escolha o nível de dificuldade (FACIL, MEDIA, DIFICIL) ou SAIR para encerrar:");
            nivel = scanner.next().toUpperCase();

            if (nivel.equals("SAIR")) {
                break; // Sai do loop de perguntas
            }

            Map<String, Integer> perguntasEscolhidas;
            switch (nivel) {
                case "FACIL":
                    perguntasEscolhidas = perguntasFaceis;
                    break;
                case "MEDIA":
                    perguntasEscolhidas = perguntasMedias;
                    break;
                case "DIFICIL":
                    perguntasEscolhidas = perguntasDificeis;
                    break;
                default:
                    System.out.println("Nível inválido! Tente novamente.");
                    continue;
            }

            // Gerando uma pergunta aleatória
            Object[] perguntasArray = perguntasEscolhidas.keySet().toArray();
            String pergunta = (String) perguntasArray[random.nextInt(perguntasArray.length)];
            int respostaCorreta = perguntasEscolhidas.get(pergunta);

            System.out.println("Pergunta: " + pergunta);
            System.out.print("Digite sua resposta: ");

            int respostaAluno;
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
            }
            respostaAluno = scanner.nextInt();

            if (respostaAluno == respostaCorreta) {
                System.out.println("✅ Correto! Parabéns! 🎉");
                if (nivel.equals("FACIL")) acertosFaceis++;
                else if (nivel.equals("MEDIA")) acertosMedios++;
                else if (nivel.equals("DIFICIL")) acertosDificeis++;
            } else {
                System.out.println("❌ Errado! A resposta correta era: " + respostaCorreta);
            }

            System.out.println("Quer outra pergunta do mesmo nível? (Digite SIM para continuar, ou qualquer outra coisa para mudar o nível)");
            continuar = scanner.next().toUpperCase();

        } while (continuar.equals("SIM"));
    }

    public void mostrarResultadoFinal() {
        System.out.println("\n=== Resultado Final do Quiz ===");
        System.out.println("Você acertou:");
        System.out.println("✅ Fácil: " + acertosFaceis + " perguntas");
        System.out.println("✅ Médio: " + acertosMedios + " perguntas");
        System.out.println("✅ Difícil: " + acertosDificeis + " perguntas");
        System.out.println("Obrigado por jogar! Até mais.");
    }

    public static void main(String[] args) {
        JogoMatematico jogo = new JogoMatematico();
        jogo.iniciarJogo();
        jogo.mostrarResultadoFinal();
    }
    public int getTotalAcertos(){
        return acertosFaceis + acertosMedios + acertosDificeis;
    }
}