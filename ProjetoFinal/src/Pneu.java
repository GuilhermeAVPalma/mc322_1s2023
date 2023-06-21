
class Pneu {
    
	private int quilometragem;
    private String marca;
    private String posicao;

    public Pneu(int quilometragem, String marca, String posicao) {
        this.quilometragem = quilometragem;
        this.marca = marca;
        this.posicao = posicao;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }    

    public int getQuilometragem() {
        return quilometragem;
    }

    public String getMarca() {
        return marca;
    }

    public String getPosicao() {
        return posicao;
    }
}
