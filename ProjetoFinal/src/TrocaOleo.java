import java.util.ArrayList;
import java.time.LocalDate;

public class TrocaOleo extends Peca{
    private int quilometragem;
    private int quilometragemProximaTroca;
    private ArrayList<String> filtros;

    

	public TrocaOleo(double valor, String modelo, String nome, String fabricante, LocalDate dataTroca,
			int quilometragem, int quilometragemProximaTroca, ArrayList<String> filtros) {
		super(valor, modelo, nome, fabricante, dataTroca);
		this.quilometragem = quilometragem;
		this.quilometragemProximaTroca = quilometragemProximaTroca;
		this.filtros = filtros;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}

	public int getQuilometragemProximaTroca() {
		return quilometragemProximaTroca;
	}
	
	public void setQuilometragemProximaTroca(int quilometragemProximaTroca) {
		this.quilometragemProximaTroca = quilometragemProximaTroca;
	}
	
	public ArrayList<String> getFiltros() {
		return filtros;
	}

	public void setFiltros(ArrayList<String> filtros) {
		this.filtros = filtros;
	}

	
	@Override
	public String toString() {
		return "TrocaOleo [" + "valor=" + valor + ", modelo=" + modelo + ", nome=" + nome + ", fabricante=" + fabricante
				+ ", dataTroca=" + dataTroca
				+ "quilometragem=" + quilometragem + ", quilometragemProximaTroca=" + quilometragemProximaTroca
				+ ", filtros=" + filtros + "]";
	}
	
	
	
	

	
}