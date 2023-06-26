import java.time.LocalDate;

public class Peca {
    protected double valor;
    protected String modelo;
    protected String nome;
    protected String fabricante;
    protected LocalDate dataTroca;
    
	public Peca(double valor, String modelo, String nome, String fabricante, LocalDate dataTroca) {
		this.valor = valor;
		this.modelo = modelo;
		this.nome = nome;
		this.fabricante = fabricante;
		this.dataTroca = dataTroca;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public LocalDate getDataTroca() {
		return dataTroca;
	}
	public void setDataTroca(LocalDate dataTroca) {
		this.dataTroca = dataTroca;
	}
	
	@Override
	public String toString() {
		return "Peca [valor=" + valor + ", modelo=" + modelo + ", nome=" + nome + ", fabricante=" + fabricante
				+ ", dataTroca=" + dataTroca + "]";
	}

    
}