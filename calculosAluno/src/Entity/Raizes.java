package Entity;

public class Raizes {
    public static double calcularRaizQuadrada(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Não é possível calcular a raiz quadrada de um número negativo.");
        }
        return Math.sqrt(numero);
    }
    public static double calcularRaizCubica(double numero) {
        return Math.cbrt(numero);
    }
}
