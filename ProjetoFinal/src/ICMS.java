import java.time.LocalDate;

public class ICMS implements Imposto {
	private final double valor;
	private LocalDate data;
	private final String nomeImposto = "ICMS";
	
	public ICMS(double valor, LocalDate data) {
		this.valor = valor;
		this.data = data;
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
