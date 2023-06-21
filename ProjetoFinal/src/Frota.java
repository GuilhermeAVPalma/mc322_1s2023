import java.util.ArrayList;
import java.util.List;

class Frota {
   
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

    public void adicionarVeiculo (String marca, String modelo, String cor, String placa){
        //chamar construtor de veiculo
    }


}