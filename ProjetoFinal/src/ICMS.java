import java.time.LocalDate;

public class ICMS implements Imposto {
	private double valor;
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
	public void setValor(double valor) {
		this.valor = valor;
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
