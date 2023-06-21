class Peca {
    private int quilometragem;
    private double valor;
    private String marca;
    private String oficina;

    public Peca(int quilometragem, double valor, String marca, String oficina) {
        this.quilometragem = quilometragem;
        this.valor = valor;
        this.marca = marca;
        this.oficina = oficina;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }    
}