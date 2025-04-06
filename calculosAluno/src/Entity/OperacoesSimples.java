package Entity;

public class OperacoesSimples {
    public static double somar(double[] numeros) {
        double resultado = 0;
        for (double numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }
    public static double subtrair(double[] numeros) {
        double resultado = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            resultado -= numeros[i];
        }
        return resultado;
    }
    public static double multiplicar(double[] numeros) {
        double resultado = 1;
        for (double numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }
    public static double dividir(double[] numeros) {
        double resultado = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] == 0) {
                throw new ArithmeticException("Divisão por zero!");
            }
            resultado /= numeros[i];
        }
        return resultado;
    }

}
