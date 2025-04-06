
package Entity;

public class Cilindro {
    private double raio;
    private double altura;

    public Cilindro(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }
    public double areaTotalCilindro(){
        return 2*(Math.PI*raio*raio) + 2*(Math.PI*raio*altura);
    }
    public double volumeCilindro (){
        return Math.PI*raio*raio*altura;
    }

    @Override
    public String toString() {
        return String.format("\nRaio: %.2f \n" + "Altura: %.2f \n" + "Volume: %.2f \n" + "Area Total: %.2f \n" ,getRaio(),getAltura()
                ,volumeCilindro(),areaTotalCilindro());
    }

    public double getRaio() {
        return raio;
    }

    public double getAltura() {
        return altura;
    }
}
