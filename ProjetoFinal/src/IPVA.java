import java.time.LocalDate;

public class IPVA implements Imposto {
	private final double valor;
	private LocalDate data;
	private final String nomeImposto;

	public IPVA(double valor, LocalDate data) {
		this.valor = valor;
		this.data = data;
		this.nomeImposto = "IPVA";
	}

	@Override
	public double getValor() {
		return valor;
	}

	@Override
	public LocalDate getData() {
		return data;
	}

	@Override
	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String getNomeImposto() {
		return nomeImposto;
	}

	@Override
	public double calculaImposto(double valorVeiculo) {
		return valor*valorVeiculo;
	}
	
}
