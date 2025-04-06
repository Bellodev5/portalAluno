package Entity;

public class Cone {
    private double raio;
    private double altura;

    public Cone(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    public String toString() {
        return String.format("\nRaio: %.2f \n" + "Altura: %.2f \n" + "Volume: %.2f \n" + "Area Total: %.2f \n" +"Geratriz: %.2f \n" ,getRaio(),getAltura()
                ,volumeCone(),areaTotalCone(), geratrizCone());
    }


    public double geratrizCone(){
        return Math.sqrt(raio*raio+altura*altura);
    }
    public double areaTotalCone(){
        return Math.PI*raio*(geratrizCone()+raio);
    }
    public double volumeCone(){
        return  3* (Math.PI*raio*raio+altura);
    }

    public double getRaio() {
        return raio;
    }

    public double getAltura() {
        return altura;
    }


}
