package Entity;

public class Esfera {
    private double raio;

    public Esfera(double raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        return String.format("\nRaio: %.2f \n" +"Volume: %.2f \n" + "Area Total: %.2f \n",getRaio(), volumeEsfera(), areaTotalEsfera());
}

    public double areaTotalEsfera(){
        return 4*(Math.PI*raio*raio);
    }
    public double volumeEsfera(){
        return 4/3 * (Math.PI*raio*raio*raio);
    }

    public double getRaio() {
        return raio;
    }
}
