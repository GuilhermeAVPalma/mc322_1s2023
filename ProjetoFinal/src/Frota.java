import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota {
   
    private String nome;
	private List<Veiculo> listaVeiculo;
    
    public Frota(String nome) {
        this.nome = nome;
        this.listaVeiculo = new ArrayList<Veiculo> () ;
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
    public void setListaVeiculo(List<Veiculo> listaVeiculo) {
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
    	
    	return totalGasto;
    }

}