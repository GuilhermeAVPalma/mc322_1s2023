import java.time.LocalDate;

public class Pneu extends Peca {
    
	private int quilometragem;
    private String marca;
    private int posicao;

    public Pneu(double valor, String modelo, String nome, String fabricante, LocalDate dataTroca, int quilometragem,
			String marca, int posicao) {
		super(valor, modelo, nome, fabricante, dataTroca);
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

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }    

    public int getQuilometragem() {
        return quilometragem;
    }

    public String getMarca() {
        return marca;
    }

    public int getPosicao() {
        return posicao;
    }
}
