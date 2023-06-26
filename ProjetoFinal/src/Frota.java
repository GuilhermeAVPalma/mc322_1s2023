import java.util.ArrayList;
import java.util.List;

public class Frota {
   
    private String nome;
	private ArrayList<Veiculo> listaVeiculo;
    private ArrayList<Manutencao> listaManutencoes;

    public Frota(String nome) {
        this.nome = nome;
        this.listaVeiculo = new ArrayList<Veiculo> () ;
        this.listaManutencoes = new ArrayList<Manutencao> () ;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Veiculo> getListaVeiculo() {
        return listaVeiculo;
    }
    public void setListaVeiculo(ArrayList<Veiculo> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
    }

    public void cadastrarVeiculo (Veiculo veiculo){
        listaVeiculo.add(veiculo);
    }
    
    public void listarVeiculos() {
    	for (Veiculo veiculo: listaVeiculo) {
    		System.out.println(veiculo + "\n");
    	}
    }
    
    public double gastoTotalFrota() {
    	double totalGasto = 0.0;
    	for(Veiculo veiculo: listaVeiculo)
    		totalGasto += veiculo.calcularGastosTotais();

        totalGasto += 50.0*listaManutencoes.size();

    	return totalGasto;
    }

    public void cadastrarManutencao(Manutencao man) {
        listaManutencoes.add(man);
    }

    @Override
    public String toString() {
        return "Frota{" +
                "nome='" + nome + '\'' +
                ", listaVeiculo=" + listaVeiculo +
                ", listaManutencoes=" + listaManutencoes +
                '}';
    }
}