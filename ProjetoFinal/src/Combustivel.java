
public class Combustivel {
    
	private int quilometragemInicial;
    private int quilometragemFinal;
    private String tipo;
    private double volume;

    public Combustivel(int quilometragemInicial, int quilometragemFinal, String tipo, double volume) {
        this.quilometragemInicial = quilometragemInicial;
        this.quilometragemFinal = quilometragemFinal;
        this.tipo = tipo;
        this.volume = volume;
    }

    public void setQuilometragemInicial(int quilometragemInicial) {
        this.quilometragemInicial = quilometragemInicial;
    }

    public void setQuilometragemFinal(int quilometragemFinal) {
        this.quilometragemFinal = quilometragemFinal;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getQuilometragemInicial() {
        return quilometragemInicial;
    }

    public int getQuilometragemFinal() {
        return quilometragemFinal;
    }
    
    public String getTipo() {
        return tipo;
    }

    public double getVolume() {
        return volume;
    }
    
    public double calcularRendimento() {
        double distanciaPercorrida = quilometragemFinal - quilometragemInicial;
        return distanciaPercorrida / volume;
    }
}