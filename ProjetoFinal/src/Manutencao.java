import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Manutencao {
	protected LocalDate dataInicio;
	protected LocalDate dataFim;

	public Manutencao(LocalDate dataInicio, LocalDate dataFim) {
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public abstract double calculaGasto();
}
