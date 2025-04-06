package Main;

import Entity.*;

import java.util.Scanner;

public class OperacoesAritmeticas {

    private Scanner scanner;
    private int qntdCalculosSimples = 0;
    private int qntdCalculosRaizes = 0;
    private int qntdCalculosFormas = 0;

    public OperacoesAritmeticas(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executarCalculos() {
        int tipo;
        do {
            System.out.println("Qual operação você deseja realizar?");
            System.out.println("0 - Nenhuma => Sair");
            System.out.println("1 - Operações Simples");
            System.out.println("2 - Raíz Quadrada e Cúbica");
            System.out.println("3 - Formas Geométricas");
            tipo = scanner.nextInt();
            scanner.nextLine();

            switch (tipo) {
                case 1 -> executarOperacoesSimples();
                case 2 -> executarCalculosRaizes();
                case 3 -> executarCalculosFormas();
                case 0 -> System.out.println("Saindo da calculadora.");
                default -> System.out.println("Opção inválida!");
            }
        } while (tipo != 0);
        mostrarResumoGeral();
    }
    public void mostrarResumoGeral() {
        int qntdCalculos = qntdCalculosSimples + qntdCalculosRaizes + qntdCalculosFormas;

        if (qntdCalculos > 1) {
            System.out.println("Você realizou " + qntdCalculos + " cálculos no geral em nosso portal.");
        } else if (qntdCalculos == 1) {
            System.out.println("Você realizou " + qntdCalculos + " cálculo no geral em nosso portal.");
        } else {
            System.out.println("Obrigado por utilizar a o nosso portal!");
            System.out.println("Você não realizou nenhum cálculo.");
        }

        System.out.println("Operações simples: " + qntdCalculosSimples);
        System.out.println("Cálculos de Raízes: " + qntdCalculosRaizes);
        System.out.println("Cálculos geométricos: " + qntdCalculosFormas);
    }

    private void executarOperacoesSimples() {
        int opcaoB;
        do {
            System.out.println("Escolha a operação:");
            System.out.println("0 - Voltar");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            opcaoB = scanner.nextInt();
            if (opcaoB == 0) break;
            qntdCalculosSimples++;
            System.out.print("Quantos números você deseja inserir? ");
            int quantidade = scanner.nextInt();
            double[] numeros = new double[quantidade];
            for (int i = 0; i < quantidade; i++) {
                System.out.print("Digite o número " + (i + 1) + ": ");
                numeros[i] = scanner.nextDouble();
            }
            switch (opcaoB) {
                case 1 -> System.out.println("Soma: " + OperacoesSimples.somar(numeros));
                case 2 -> System.out.println("Subtração: " + OperacoesSimples.subtrair(numeros));
                case 3 -> System.out.println("Multiplicação: " + OperacoesSimples.multiplicar(numeros));
                case 4 -> {
                    try {
                        System.out.println("Divisão: " + OperacoesSimples.dividir(numeros));
                    } catch (ArithmeticException e) {
                        System.out.println("Erro na divisão: " + e.getMessage());
                    }
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (true);
    }

    private void executarCalculosRaizes() {
        int opcaoB;
        do {
            System.out.println("Escolha a operação:");
            System.out.println("0 - Voltar");
            System.out.println("1 - Raiz Quadrada");
            System.out.println("2 - Raiz Cúbica");
            opcaoB = scanner.nextInt();
            if (opcaoB == 0) break;
            qntdCalculosRaizes++;

            System.out.print("Digite um número: ");
            double numero = scanner.nextDouble();
            switch (opcaoB) {
                case 1 -> System.out.println("Raiz Quadrada: " + Raizes.calcularRaizQuadrada(numero));
                case 2 -> System.out.println("Raiz Cúbica: " + Raizes.calcularRaizCubica(numero));
                default -> System.out.println("Opção inválida!");
            }
        } while (true);
    }

    private void executarCalculosFormas() {
        int opcaoB;
        double raio;
        double altura;
        do {
            System.out.println("Escolha a forma geométrica:");
            System.out.println("0 - Voltar");
            System.out.println("1 - Cilindro");
            System.out.println("2 - Cone");
            System.out.println("3 - Esfera");
            opcaoB = scanner.nextInt();
            if (opcaoB == 0) break;
            qntdCalculosFormas++;
            switch (opcaoB) {
                case 1 -> {
                    System.out.print("Digite o raio: ");
                    raio = scanner.nextDouble();
                    System.out.print("Digite a altura: ");
                    altura = scanner.nextDouble();
                    Cilindro cilindro = new Cilindro(raio, altura);
                    System.out.println(cilindro.toString());
                }
                case 2 -> {
                    System.out.print("Digite o raio: ");
                    raio = scanner.nextDouble();
                    System.out.print("Digite a altura: ");
                    altura = scanner.nextDouble();
                    Cone cone = new Cone(raio, altura);
                    System.out.println(cone.toString());
                }
                case 3 -> {
                    System.out.print("Digite o raio: ");
                    raio = scanner.nextDouble();
                    Esfera esfera = new Esfera(raio);
                    System.out.println(esfera.toString());
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (true);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperacoesAritmeticas calculadora = new OperacoesAritmeticas(scanner);
        calculadora.executarCalculos();
        scanner.close();
    }
    public int getTotalCalculos() {
        return qntdCalculosSimples + qntdCalculosRaizes + qntdCalculosFormas;
    }

}